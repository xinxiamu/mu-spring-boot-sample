package co.jufeng.esign.common.paasapi;

import co.jufeng.esign.common.paasapi.vo.*;

/**
 * 电子签名 PaaS API
 */
public interface ESignSealService {

    /**
     * 创建个人模板印章
     * @param req
     * @return
     */
    SealDataResult personalTemplate(SealDataReq req);

    /**
     * 创建机构模板印章
     * @param req
     * @return
     */
    SealDataResult officialTemplate(SealDataReq req);

    /**
     * 通过上传方式创建文件
     * @param pdfFileUrl 待签署pdf文件在第三平台的url地址。
     * @return
     */
    VUploadFile uploadFile(String pdfFileUrl);

    /**
     * 获取文件详情。
     * @param fileId
     * @return
     */
    VPdfFileInfo getPdfFileInfo(String fileId);

    /**
     * 搜索文件关键字坐标。
     * @param fileId
     * @return
     */
    VWordsPosition searchWordsPosition(String fileId, String keywords);

    /**
     * 一步发起签署
     * @param vo
     * @return
     */
    VCreateFlowOneStep createFlowOneStep(VCreateFlowOneStepReq vo);

    /**
     * 获取签署文件地址。
     * @param flowId
     * @param accountId
     * @param organizeId
     * @return
     */
    VExecuteUrl executeUrl(String flowId, String accountId, String organizeId);

    /**
     * 流程文档下载
     * @param flowId 一步签署返回的flowId
     * @return
     */
    VDocuments documents(String flowId);
}
