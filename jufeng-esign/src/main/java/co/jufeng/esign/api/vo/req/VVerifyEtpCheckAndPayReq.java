package co.jufeng.esign.api.vo.req;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class VVerifyEtpCheckAndPayReq implements Serializable {

    private static final long serialVersionUID = -6132554323365994408L;
    /**
     * flowId : 实名认证流程id
     * province : 浙江
     * subbranch : 平安银行杭州高新支行
     * bank : 平安银行
     * city : 杭州市
     * cnapsCode : 307***2584
     * cardNo : 110034**75702
     */

    /**
     * 实名认证流程id
     */
    @NotBlank
    private String flowId;
    /**
     * 对公账号开户行所在省份名称
     */
    @NotBlank
    private String province;
    /**
     * 对公账号开户行支行名称全称
     */
    @NotBlank
    private String subbranch;
    /**
     * 对公账号开户行总行名称
     */
    @NotBlank
    private String bank;
    /**
     * 对公账号开户行所在城市名称
     */
    @NotBlank
    private String city;
    /**
     * 联行号（名词解释） 可通过 查询打款银行信息 获取，或第三方数据库获取
     */
    @NotBlank
    private String cnapsCode;
    /**
     * 银行卡号信息
     */
    @NotBlank
    private String cardNo;

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getSubbranch() {
        return subbranch;
    }

    public void setSubbranch(String subbranch) {
        this.subbranch = subbranch;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCnapsCode() {
        return cnapsCode;
    }

    public void setCnapsCode(String cnapsCode) {
        this.cnapsCode = cnapsCode;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}
