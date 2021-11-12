package co.jufeng.esign.api.vo.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VVerifyEnterpriseReq implements Serializable {

    private static final long serialVersionUID = 6680217524440541151L;


    /**
     * name : 杭州天谷信息科技有限公司
     * codeORG :
     * codeUSC : 9133******077
     * codeREG : 330********3512
     * legalName : 何***
     * legalIdno : 330****
     */

    /**
     * 企业名称
     */
    @NotBlank
    private String name;
    /**
     * 组织机构代码，codeORG、codeUSC、codeREG 选填其中之一
     */
    private String codeORG;
    /**
     * 社会统一信用代码，codeORG、codeUSC、codeREG 选填其中
     * 之一
     */
    private String codeUSC;
    /**
     * 工商注册号，codeORG、codeUSC、codeREG 选填其中之一
     */
    private String codeREG;
    /**
     * 法人姓名
     */
    @NotBlank
    private String legalName;
    /**
     * 法人身份证号码
     */
    private String legalIdno;
}
