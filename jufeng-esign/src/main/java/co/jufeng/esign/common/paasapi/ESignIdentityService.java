package co.jufeng.esign.common.paasapi;


import co.jufeng.esign.common.paasapi.vo.*;

import javax.validation.Valid;

/**
 * 认证服务 API
 */
public interface ESignIdentityService {

    /**
     * 创建个人账号
     * @param req
     * @return
     */
    VAccountPerson createByThirdPartyUserId(@Valid VAccountPersonReq req);

    /**
     * 注销个人账号
     * @param accountId
     * @return
     */
    Resp delAccount(String accountId);

    /**
     * 发起运营商3要素实名认证
     * @param req
     * @return
     */
    Telecom3Factors telecom3Factors(@Valid Telecom3FactorsReq req, String accountId);

    /**
     * 运营商短信验证码校验
     * @param req
     * @return
     */
    Resp telecom3FactorsAuthCode(@Valid AuthCodeReq req, String flowId);

    /*========================== 企业实名认证 start =========================*/

    /**
     * 创建机构账号
     * @param req
     * @return
     */
    VAccountOrg createByThirdPartyUserId(@Valid VAccountOrgReq req);

    /**
     * 注销机构账号
     * @param orgId
     * @return
     */
    Resp delOrganizations(String orgId);

    /**
     * 发起企业实名认证4要素校验
     * @param req
     * @param accountId
     * @return
     */
    VFourFactors fourFactors(@Valid VFourFactorsReq req, String accountId);

    /**
     * 查询打款银行信息
     * @param keyWord
     * @param flowId
     * @return
     */
    VSubbranch subbranch(String keyWord, String flowId);

    /**
     * 发起随机金额打款认证
     * @param req
     * @return
     */
    Resp transferRandomAmount(@Valid VTransferRandomAmountReq req, String flowId);

    /**
     * 随机金额校验
     * @param req
     * @return
     */
    Resp verifyRandomAmount(@Valid VVerifyRandomAmountReq req, String flowId);

    /*========================== 企业实名认证 end =========================*/
}
