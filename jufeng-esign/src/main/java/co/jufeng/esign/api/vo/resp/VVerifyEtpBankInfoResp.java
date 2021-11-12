package co.jufeng.esign.api.vo.resp;

import java.io.Serializable;

public class VVerifyEtpBankInfoResp implements Serializable {
    private static final long serialVersionUID = -8289051927671590649L;

    /**
     * 支行全称。
     */
    private String bankName;
    /**
     * 银行总行名称
     */
    private String bank;
    /**
     * 联行号
     */
    private String cnapsCode;
    /**
     * 所在市
     */
    private String city;
    /**
     * 所在省
     */
    private String province;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCnapsCode() {
        return cnapsCode;
    }

    public void setCnapsCode(String cnapsCode) {
        this.cnapsCode = cnapsCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
