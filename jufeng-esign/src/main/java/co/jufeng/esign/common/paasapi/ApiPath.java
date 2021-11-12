package co.jufeng.esign.common.paasapi;

import java.text.MessageFormat;

public interface ApiPath {

    // 获取token
    static String getTokenPath(String appId, String secret) {
        String path = MessageFormat.format("/v1/oauth2/access_token?appId={0}&secret={1}&grantType=client_credentials", appId, secret);
        return path;
    }

    /**
     * 创建个人账号。
     */
    String CREATE_BY_THIRD_PART_USER_ID = "/v1/accounts/createByThirdPartyUserId";

    /**
     * 注销个人账户
     * @param accountId
     * @return
     */
    static String getDelAccountPath(String accountId) {
        String path = MessageFormat.format("/v1/accounts/{0}", accountId);
        return path;
    }

    /**
     * 运营商3要素实名认证
     * @param accountId
     * @return
     */
    static String getTelecom3Factors(String accountId) {
        String path = MessageFormat.format("/v2/identity/auth/api/individual/{0}/telecom3Factors", accountId);
        return path;
    }

    /**
     * 回填校验运营商三要素短信验证码
     * @param flowId
     * @return
     */
    static String getTelecom3FactorsAuth(String flowId) {
        String path = MessageFormat.format("/v2/identity/auth/pub/individual/{0}/telecom3Factors", flowId);
        return path;
    }

    /**
     * 创建机构账号
     */
    String CREATE_BY_THIRD_PARTY_USER_ID = "/v1/organizations/createByThirdPartyUserId";

    /**
     * 注销机构账号
     * @param orgId 一创建的机构id
     * @return
     */
    static String getDelOrgPath(String orgId) {
        String path = MessageFormat.format("/v1/organizations/{0}", orgId);
        return path;
    }

    /**
     * 发起企业实名认证4要素校验
     * @param accountId 企业账号
     * @return
     */
    static String getFourFactors(String accountId) {
        String path = MessageFormat.format("/v2/identity/auth/api/organization/enterprise/{0}/fourFactors", accountId);
        return path;
    }

    /**
     * 查询打款银行信息
     * @param flowId
     * @return
     */
    static String getSubbranch(String flowId) {
        String path = MessageFormat.format("/v2/identity/auth/pub/organization/{0}/subbranch", flowId);
        return path;
    }

    /**
     * 发起随机金额打款认证
     * @param flowId
     * @return
     */
    static String getTransferRandomAmount(String flowId) {
        String path = MessageFormat.format("/v2/identity/auth/pub/organization/{0}/transferRandomAmount", flowId);
        return path;
    }

    /**
     * 随机金额校验
     * @param flowId
     * @return
     */
    static String getVerifyRandomAmount(String flowId) {
        String path = MessageFormat.format("/v2/identity/auth/pub/organization/{0}/verifyRandomAmount", flowId);
        return path;
    }

    /*=============================== 签署文件 start =================================*/

    /**
     * 创建个人模板印章
     * @param accountId 个人账号
     * @return
     */
    static String personaltemplate(String accountId) {
        String path = MessageFormat.format("/v1/accounts/{0}/seals/personaltemplate", accountId);
        return path;
    }

    /**
     * 创建机构模板印章
     * @param accountId 企业账号orgId
     * @return
     */
    static String officialtemplate(String accountId) {
        String path = MessageFormat.format("/v1/organizations/{0}/seals/officialtemplate", accountId);
        return path;
    }

    /**
     * 通过上传方式创建文件
     */
    String UPLOAD_FILE_URL =  "/v1/files/getUploadUrl";

    /**
     * 查询文件详情/下载文件
     * @param fileId
     * @return
     */
    static String getFileInfo(String fileId) {
        String path = MessageFormat.format("/v1/files/{0}", fileId);
        return path;
    }

    /**
     * 搜索关键字坐标
     * @param fileId
     * @return
     */
    static String searchWordsPosition(String fileId) {
        String path = MessageFormat.format("/v1/documents/{0}/searchWordsPosition", fileId);
        return path;
    }

    /**
     * 一步发起签署
     */
    String CREATE_FLOW_ONE_STEP = "/api/v2/signflows/createFlowOneStep";

    /**
     * 获取签署地址
     * @param flowId
     * @return
     */
    static String executeUrl(String flowId) {
        String path = MessageFormat.format("/v1/signflows/{0}/executeUrl", flowId);
        return path;
    }

    /**
     * 签署流程文档下载
     * @param flowId
     * @return
     */
    static String documents(String flowId) {
        String path = MessageFormat.format("/v1/signflows/{0}/documents", flowId);
        return path;
    }

    /*=============================== 签署文件 end =================================*/
}
