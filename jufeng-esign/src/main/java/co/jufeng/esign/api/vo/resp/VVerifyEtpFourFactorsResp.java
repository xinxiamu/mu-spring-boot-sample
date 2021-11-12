package co.jufeng.esign.api.vo.resp;

import java.io.Serializable;

public class VVerifyEtpFourFactorsResp implements Serializable {

    private static final long serialVersionUID = -296964968995291943L;

    /**
     * 企业实名认证流水号
     */
    private String flowId;
    /**
     * 组织机构账号ID
     */
    private String orgId;

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}
