package co.jufeng.esign.api.vo.req;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class VVerifyPersonalAuthReq implements Serializable {
    private static final long serialVersionUID = -5748586376733071213L;

    /**
     * 运营商3要素，个人实名认证流水号。
     */
    @NotBlank
    private String flowId;
    /**
     * 短信验证码。
     */
    @NotBlank
    private String authCode;
    /**
     * 上一步返回的个人账号id。
     */
    @NotBlank
    private String accountId;

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
