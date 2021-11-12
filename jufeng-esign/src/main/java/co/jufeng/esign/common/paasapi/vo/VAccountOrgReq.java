package co.jufeng.esign.common.paasapi.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Data
public class VAccountOrgReq {

    /**
     * thirdPartyUserId : 20190826110230222
     * creator : 1c04a729df94422ab8c8b664b5b1370e
     * idNumber : 913301087458306077
     * idType : CRED_ORG_USCC
     * name : 杭州天谷信息科技有限公司
     * orgLegalIdNumber : xxxxxxxxxxxxxxx
     * orgLegalName : xxxxx
     */

    /**
     * 机构唯一标识，可传入第三方平台机构id、企业证件号、企业邮箱等如果设置则作为账号唯一性字段，相同id不可重复创建。（个人用户与机构的唯一标识不可重复）
     *
     * 用企业记录id即可。
     */
    @NotBlank
    @JSONField(name = "thirdPartyUserId")
    private String thirdPartyUserId;
    /**
     * 创建人个人账号id（调用个人账号创建接口返回的accountId）
     */
    @NotBlank
    @JSONField(name = "creator")
    private String creator;
    /**
     * 证件号，默认为空，发起签署前需确保补齐证件号
     *
     * 注：如果调用“认证服务纯API版”接口时，该字段必传
     */
    @NotBlank
    @JSONField(name = "idNumber")
    private String idNumber;
    /**
     * 证件类型，默认CRED_ORG_USCC
     *
     * （1）CRED_ORG_USCC统一社会信用代码，默认值
     *
     * （2）CRED_ORG_REGCODE工商注册号
     *
     * 注：如果调用“认证服务纯API版”接口时，该字段必传
     */
    @NotBlank
    @JSONField(name = "idType")
    private String idType;
    /**
     * 机构名称
     */
    @NotBlank
    @JSONField(name = "name")
    private String name;
    /**
     * 企业法人证件号
     *
     * 注：如果调用“认证服务纯API版”接口，并发起“企业实名认证四要素校验”时，该字段必填
     */
    @NotBlank
    @JSONField(name = "orgLegalIdNumber")
    private String orgLegalIdNumber;
    /**
     * 企业法人名称
     *
     * 注：如果调用“认证服务纯API版”接口，并发起“企业实名认证三要素/四要素校验”时，该字段必填
     */
    @NotBlank
    @JSONField(name = "orgLegalName")
    private String orgLegalName;
}
