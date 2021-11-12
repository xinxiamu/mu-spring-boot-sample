package co.jufeng.esign.controller;

import co.jufeng.esign.api.ESignPaasApi;
import co.jufeng.esign.api.vo.req.*;
import co.jufeng.esign.api.vo.resp.*;
import co.jufeng.esign.common.APIs;
import co.jufeng.esign.common.paasapi.ESignIdentityService;
import co.jufeng.esign.common.paasapi.ESignSealService;
import co.jufeng.esign.common.paasapi.vo.Resp;
import co.jufeng.esign.common.paasapi.vo.*;
import co.jufeng.esign.mappers.ESignMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
public class ESignPaasController implements ESignPaasApi {

    private final ESignIdentityService eSignIdentityService;
    private final ESignSealService eSignSealService;

    @Autowired
    public ESignPaasController(ESignIdentityService eSignIdentityService, ESignSealService eSignSealService) {
        this.eSignIdentityService = eSignIdentityService;
        this.eSignSealService = eSignSealService;
    }

    @Override
    public VVerifyPersonalResp verifyPersonal(VPersonalReq vo) {
        VAccountPersonReq vAccountPersonReq = new VAccountPersonReq();
        vAccountPersonReq.setThirdPartyUserId(vo.getThirdPartyUserId());
        vAccountPersonReq.setName(vo.getName());
        vAccountPersonReq.setIdNumber(vo.getIdno());

        VAccountPerson vAccountPerson = eSignIdentityService.createByThirdPartyUserId(vAccountPersonReq);
        String accountId = vAccountPerson.getData().getAccountId();
        if (vAccountPerson.getCode() == 53000000) { //账号已经存在,删除
            Resp resp = eSignIdentityService.delAccount(accountId);
            if (resp.getCode() == 0) {
                //重新创建个人账号
                vAccountPerson = eSignIdentityService.createByThirdPartyUserId(vAccountPersonReq);
                accountId = vAccountPerson.getData().getAccountId();
            }
        }

        Telecom3FactorsReq telecom3FactorsReq = new Telecom3FactorsReq();
        telecom3FactorsReq.setMobileNo(vo.getMobile());
        Telecom3Factors tResp = eSignIdentityService.telecom3Factors(telecom3FactorsReq, accountId);

        VVerifyPersonalResp resp = new VVerifyPersonalResp();
        resp.setAccountId(accountId);
        resp.setFlowId(tResp.getData().getFlowId());

        return resp;
    }

    @Override
    public Boolean verifyPersonalAuth(VVerifyPersonalAuthReq vo) {
        AuthCodeReq authCodeReq = new AuthCodeReq();
        authCodeReq.setAuthcode(vo.getAuthCode());
        Resp resp = eSignIdentityService.telecom3FactorsAuthCode(authCodeReq, vo.getFlowId());
        //把AccountId,flowId更新到用户信息表
        return resp.getCode() == 0 ? true : false;
    }

    @Override
    public VVerifyEtpFourFactorsResp verifyEtpFourFactors(VVerifyEtpReq vo) {
        //第一步，创建企业账号。
        VAccountOrgReq vAccountOrgReq = new VAccountOrgReq();
        vAccountOrgReq.setThirdPartyUserId(vo.getEtpId());
        vAccountOrgReq.setCreator(vo.getCreator());
        vAccountOrgReq.setName(vo.getName());
        vAccountOrgReq.setIdNumber(vo.getIdNumber());
        vAccountOrgReq.setIdType("CRED_ORG_USCC");
        vAccountOrgReq.setOrgLegalName(vo.getOrgLegalName());
        vAccountOrgReq.setOrgLegalIdNumber(vo.getOrgLegalIdNumber());

        VAccountOrg vAccountOrg = eSignIdentityService.createByThirdPartyUserId(vAccountOrgReq);
        String orgId = vAccountOrg.getData().getOrgId();
        if (vAccountOrg.getCode() == 53000000) {
            log.info("机构已存在");
            Resp resp = eSignIdentityService.delOrganizations(orgId);
            if (resp.getCode() == 0) { //注销机构账号成功，下面重新创建机构账号
                vAccountOrg = eSignIdentityService.createByThirdPartyUserId(vAccountOrgReq);
                orgId = vAccountOrg.getData().getOrgId();
            }
        }

        //第二步，企业4要素校验。
        VFourFactorsReq vFourFactorsReq = new VFourFactorsReq();
        vFourFactorsReq.setAgentAccountId(vo.getCreator());
        VFourFactors vFourFactors = eSignIdentityService.fourFactors(vFourFactorsReq, orgId);

        VVerifyEtpFourFactorsResp resp = new VVerifyEtpFourFactorsResp();
        resp.setFlowId(vFourFactors.getData().getFlowId());
        resp.setOrgId(orgId);

        return resp;
    }

    @Override
    public List<VVerifyEtpBankInfoResp> verifyEtpBankInfo(String flowId, String keyWord) {
        if (StringUtils.isEmpty(flowId)) {
            throw APIs.error(1001, "实名认证流水ID非空", null);
        }
        if (StringUtils.isEmpty(keyWord)) {
            throw APIs.error(1001, "支行名称非空", null);
        }

        VSubbranch vSubbranch = eSignIdentityService.subbranch(keyWord, flowId);
        List<VSubbranch.DataDTO.ListDTO> list = vSubbranch.getData().getList();
        if (null == list || list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        List<VVerifyEtpBankInfoResp> dataList = new ArrayList<>();
        for (VSubbranch.DataDTO.ListDTO dto: list) {
            VVerifyEtpBankInfoResp bankInfoResp = new VVerifyEtpBankInfoResp();
            bankInfoResp.setBank(dto.getBank());
            bankInfoResp.setBankName(dto.getBankName());
            bankInfoResp.setProvince(dto.getProvince());
            bankInfoResp.setCity(dto.getCity());
            bankInfoResp.setCnapsCode(dto.getCnapsCode());

            dataList.add(bankInfoResp);
        }
        return dataList;
    }

    @Override
    public Boolean verifyEtpCheckAndPay(@Valid VVerifyEtpCheckAndPayReq req) {
        VTransferRandomAmountReq vTransferRandomAmountReq = new VTransferRandomAmountReq();
        vTransferRandomAmountReq.setBank(req.getBank());
        vTransferRandomAmountReq.setSubbranch(req.getSubbranch());
        vTransferRandomAmountReq.setCardNo(req.getCardNo());
        vTransferRandomAmountReq.setCnapsCode(req.getCnapsCode());
        vTransferRandomAmountReq.setProvince(req.getProvince());
        vTransferRandomAmountReq.setCity(req.getCity());
//        vTransferRandomAmountReq.setNotifyUrl("");  //设置打款回调地址
        eSignIdentityService.transferRandomAmount(vTransferRandomAmountReq, req.getFlowId());
        return true;
    }

    @Override
    public Boolean verifyEtpCheckPayMoney(String flowId, double amount) {
        VVerifyRandomAmountReq vVerifyRandomAmountReq = new VVerifyRandomAmountReq();
        vVerifyRandomAmountReq.setAmount(amount);
        eSignIdentityService.verifyRandomAmount(vVerifyRandomAmountReq, flowId);
        return true;
    }

    @Override
    public VGenSealsResp genSeals(VGenSealsReq vo) {
        SealDataReq req = new SealDataReq();
        req.setAccountId(vo.getAccountId());
        req.setAlias(vo.getAlias());
        SealDataResult sealDataResult;
        if (vo.getType() == 1) {
            sealDataResult = eSignSealService.personalTemplate(req);
        } else {
            sealDataResult = eSignSealService.officialTemplate(req);
        }
        if (sealDataResult.getCode() != 0) {
            throw APIs.error(sealDataResult.getCode(), sealDataResult.getMessage(), null);
        }
        VGenSealsResp resp = new VGenSealsResp();
        resp.setFileKey(sealDataResult.getData().getFileKey());
        resp.setHeight(sealDataResult.getData().getHeight());
        resp.setSealId(sealDataResult.getData().getSealId());
        resp.setUrl(sealDataResult.getData().getUrl());
        resp.setWidth(sealDataResult.getData().getWidth());
        return resp;
    }

    @Override
    public String uploadPdfFile(String pdfFileUrl) {
        VUploadFile resp = eSignSealService.uploadFile(pdfFileUrl);
        return resp.getData().getFileId();
    }

    @Override
    public ESignPdfFileInfoResp getFileInfo(String fileId) {
        VPdfFileInfo vPdfFileInfo = eSignSealService.getPdfFileInfo(fileId);

        ESignPdfFileInfoResp resp = new ESignPdfFileInfoResp();
        resp.setName(vPdfFileInfo.getData().getName());
        resp.setDownloadUrl(vPdfFileInfo.getData().getDownloadUrl());
        resp.setPdfTotalPages(vPdfFileInfo.getData().getPdfTotalPages());

        return resp;
    }

    @Override
    public List<VFileKeyWordsPositionResp> getFileKeyWordsPosition(String fileId, String keywords) {
        VWordsPosition vWordsPosition = eSignSealService.searchWordsPosition(fileId, keywords);
        List<VFileKeyWordsPositionResp> resp = ESignMapper.INSTANCE.toVFileKeyWordsPositionRespList(vWordsPosition.getData());
        return resp;
    }

    @Override
    public VDoSignResp createSignFlow(VDoSignReq req) {
        VCreateFlowOneStepReq vo = ESignMapper.INSTANCE.vDoSignReqTo(req);
        VCreateFlowOneStep resp = eSignSealService.createFlowOneStep(vo);
        VDoSignResp vDoSignResp = new VDoSignResp();
        vDoSignResp.setFlowId(resp.getData().getFlowId());
        return vDoSignResp;
    }

    @Override
    public VDoSignUrlResp getDoSigUrl(String flowId, String accountId, String organizeId) {
        VExecuteUrl vExecuteUrl = eSignSealService.executeUrl(flowId, accountId, organizeId);
        VDoSignUrlResp vDoSignUrlResp = new VDoSignUrlResp();
        vDoSignUrlResp.setShortUrl(vExecuteUrl.getData().getShortUrl());
        vDoSignUrlResp.setUrl(vExecuteUrl.getData().getUrl());
        return vDoSignUrlResp;
    }

    @Override
    public List<VSignFileInfoResp> getSignFileInfo(String flowId) {
        VDocuments vDocuments = eSignSealService.documents(flowId);
        List<VSignFileInfoResp> list = new ArrayList<>();
        for (VDocuments.DataDTO.DocsDTO dto: vDocuments.getData().getDocs()) {
            VSignFileInfoResp vSignFileInfoResp = new VSignFileInfoResp();
            vSignFileInfoResp.setFileId(dto.getFileId());
            vSignFileInfoResp.setFileName(dto.getFileName());
            vSignFileInfoResp.setFileUrl(dto.getFileUrl());

            list.add(vSignFileInfoResp);
        }
        return list;
    }
}
