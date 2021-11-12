package co.jufeng.esign.api.vo.req;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 生成企业账户。证书。请求vo
 */
public class VESignAddOrganizeReq implements Serializable {


	/**
     * email : test@timevale.com
     * mobile : 15712345678
     * name : 测试个人
     * organType : 0
     * userType : 2
     * organCode : 774013008
     * legalName : 测试法人
     * legalIdNo : 652828199207113111
     * legalArea : 0
     * agentIdNo :
     * agentName :
     * address : 天堂软件园
     * scope :
     * regType : NORMAL
     */

    /**
     * 邮箱地址
     */
    private String email;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 机构名称
     */
    @NotBlank
    private String name;
    /**
     * 单位类型，0-普通企业，1-社会团体，2-事业单位，3-民办非企业单位，4-党政及国家机构，默认0
     */
    private int organType;
    /**
     * 注册类型，0-缺省注册，1-代理人注册，2-法人注册，默认0
     */
    private int userType;
    /**
     * 组织机构代码、工商注册号或者统一社会信用代码
     */
    @NotBlank
    private String organCode;
    /**
     * 法定代表姓名，法人注册时必填
     */
    private String legalName;
    /**
     * 法定代表身份证号/护照号，法人注册时必填
     */
    private String legalIdNo;
    /**
     * 法定代表人归属地，0-大陆，1-香港，2-澳门，3-台湾，4-外籍，默认0
     */
    private int legalArea;
    /**
     * 代理人身份证号，代理人注册时必填
     */
    private String agentIdNo;
    /**
     * 代理人姓名，代理人注册时必填
     */
    private String agentName;
    /**
     * 公司地址
     */
    private String address;
    /**
     * 经营范围
     */
    private String scope;
    /**
     * 企业注册类型，NORMAL（组织机构代码）、MERGE（社会信用代码）、REGCODE（工商注册号），默认NORMAL
     */
    @NotBlank
    private String regType;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrganType() {
        return organType;
    }

    public void setOrganType(int organType) {
        this.organType = organType;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getLegalIdNo() {
        return legalIdNo;
    }

    public void setLegalIdNo(String legalIdNo) {
        this.legalIdNo = legalIdNo;
    }

    public int getLegalArea() {
        return legalArea;
    }

    public void setLegalArea(int legalArea) {
        this.legalArea = legalArea;
    }

    public String getAgentIdNo() {
        return agentIdNo;
    }

    public void setAgentIdNo(String agentIdNo) {
        this.agentIdNo = agentIdNo;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getRegType() {
        return regType;
    }

    public void setRegType(String regType) {
        this.regType = regType;
    }
}
