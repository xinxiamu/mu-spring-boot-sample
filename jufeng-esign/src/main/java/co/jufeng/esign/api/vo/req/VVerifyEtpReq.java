package co.jufeng.esign.api.vo.req;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class VVerifyEtpReq implements Serializable {

    private static final long serialVersionUID = -1020555324207099736L;
    /**
     * 机构唯一标识，企业id。
     */
    @NotBlank
    private String etpId;
    /**
     * 创建人个人账号id（调用个人账号创建接口返回的accountId）
     */
    @NotBlank
    private String creator;
    /**
     * 机构名称，公司名称。
     */
    @NotBlank
    private String name;
    /**
     * 企业统一社会信用代码
     */
    @NotBlank
    private String idNumber;
    /**
     * 企业法人名称
     */
    @NotBlank
    private String orgLegalName;
    /**
     * 企业法人身份证号码。
     */
    @NotBlank
    private String orgLegalIdNumber;

    public String getEtpId() {
        return etpId;
    }

    public void setEtpId(String etpId) {
        this.etpId = etpId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getOrgLegalName() {
        return orgLegalName;
    }

    public void setOrgLegalName(String orgLegalName) {
        this.orgLegalName = orgLegalName;
    }

    public String getOrgLegalIdNumber() {
        return orgLegalIdNumber;
    }

    public void setOrgLegalIdNumber(String orgLegalIdNumber) {
        this.orgLegalIdNumber = orgLegalIdNumber;
    }
}
