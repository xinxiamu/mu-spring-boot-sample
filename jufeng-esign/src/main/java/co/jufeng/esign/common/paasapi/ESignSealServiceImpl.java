package co.jufeng.esign.common.paasapi;

import co.jufeng.esign.common.APIs;
import co.jufeng.esign.common.StringUtil;
import co.jufeng.esign.common.paasapi.vo.*;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class ESignSealServiceImpl extends ESignBaseService implements ESignSealService {

    @Override
    public SealDataResult personalTemplate(SealDataReq req) {
        if (StringUtil.isEmpty(req.getAccountId())) {
            throw APIs.error(1001, "个人账号id非空", null);
        }
        if (StringUtil.isEmpty(req.getAlias())) {
            throw APIs.error(1002, "非空，一般个人真实姓名作为印章名称", null);
        }
        if (StringUtil.isEmpty(req.getColor())) {
            req.setColor("RED");
        }
        if (StringUtil.isEmpty(req.getType())) {
            req.setType("SQUARE");
        }
        return httpCall(ApiPath.personaltemplate(req.getAccountId()), req, HttpMethod.POST, SealDataResult.class);
    }

    @Override
    public SealDataResult officialTemplate(SealDataReq req) {
        if (StringUtil.isEmpty(req.getAccountId())) {
            throw APIs.error(1001, "参数accountId非空。传企业orgId", null);
        }
        if (StringUtil.isEmpty(req.getAlias())) {
            throw APIs.error(1002, "非空，企业全名作为印章名称", null);
        }
        if (StringUtil.isEmpty(req.getColor())) {
            req.setColor("RED");
        }
        if (StringUtil.isEmpty(req.getType())) {
            req.setType("TEMPLATE_ROUND");
        }
        if (StringUtil.isEmpty(req.getCentral())) {
            req.setCentral("STAR");
        }
        return httpCall(ApiPath.officialtemplate(req.getAccountId()), req, HttpMethod.POST, SealDataResult.class);
    }

    @Override
    public VUploadFile uploadFile(String pdfFileUrl) {
        if (StringUtil.isEmpty(pdfFileUrl)) {
            throw APIs.error(1001, "参数pdfFileUrl非空", null);
        }
        String path = getFileFromFileSystem(pdfFileUrl);
        File file = new File(path);

        VUploadFileReq req = new VUploadFileReq();
        req.setConvert2Pdf(false);
        req.setContentType("application/pdf");
        String contentMD5 = FileMd5Utils.getStringContentMD5(path);
        req.setContentMd5(contentMD5);
        String fileName = FilenameUtils.getName(pdfFileUrl);
        req.setFileName(fileName);
        Integer fileSize = Math.toIntExact(FileUtils.sizeOf(file));
        req.setFileSize(fileSize);

        VUploadFile vUploadFile = httpCall(ApiPath.UPLOAD_FILE_URL, req, HttpMethod.POST, VUploadFile.class);

        //按照获取的文件上传地址上传文件
        String url = vUploadFile.getData().getUploadUrl();
        final OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-MD5", contentMD5)
                .addHeader("Content-Type", "application/pdf")
                .put(RequestBody.create(MediaType.parse("application/pdf"), file))
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            String jsonStr = response.body().string();
            JSONObject jsonObject = JSONObject.parseObject(jsonStr);
            int errCode = jsonObject.getIntValue("errCode");
            String msg = jsonObject.getString("msg");
            if (errCode != 0) {
                throw APIs.error(errCode, msg, null);
            }
        } catch (IOException e) {
            log.error(">>>>>上传文件失败{}", url, e);
            throw APIs.error(50002, "上传文件异常", null);
        }

        return vUploadFile;
    }

    @Override
    public VPdfFileInfo getPdfFileInfo(String fileId) {
        if (StringUtil.isEmpty(fileId)) {
            throw APIs.error(1001, "esign文件fileId非空", null);
        }
        VPdfFileInfo vPdfFileInfo = httpCall(ApiPath.getFileInfo(fileId), null, VPdfFileInfo.class);
        return vPdfFileInfo;
    }

    @Override
    public VWordsPosition searchWordsPosition(String fileId, String keywords) {
        if (StringUtil.isEmpty(fileId)) {
            throw APIs.error(1001, "esign文件fileId非空", null);
        }
        Map<String, String> parMap = new HashMap<>();
        parMap.put("keywords", keywords);
        VWordsPosition vWordsPosition = httpCall(ApiPath.searchWordsPosition(fileId), parMap, VWordsPosition.class);
        return vWordsPosition;
    }

    @Override
    public VCreateFlowOneStep createFlowOneStep(VCreateFlowOneStepReq vo) {
        VCreateFlowOneStep resp = httpCall(ApiPath.CREATE_FLOW_ONE_STEP, vo, HttpMethod.POST, VCreateFlowOneStep.class);
        return resp;
    }

    @Override
    public VExecuteUrl executeUrl(String flowId, String accountId, String organizeId) {
        Map<String, String> parMap = new HashMap<>();
        parMap.put("accountId", accountId);
        parMap.put("organizeId", organizeId);
        VExecuteUrl vExecuteUrl = httpCall(ApiPath.executeUrl(flowId), parMap, VExecuteUrl.class);
        return vExecuteUrl;
    }

    @Override
    public VDocuments documents(String flowId) {
        VDocuments vDocuments = httpCall(ApiPath.documents(flowId), null, HttpMethod.GET, VDocuments.class);
        return vDocuments;
    }
}
