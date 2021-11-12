package co.jufeng.esign.common.paasapi.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Data
public class VAccountPersonReq {

    /**
     * thirdPartyUserId : 2019082630111
     * name : 芜浣
     * idType : CRED_PSN_CH_IDCARD
     * idNumber : 371204199604234930
     * mobile : 182681xxxxx
     * email : wuhuan@tsign.com
     */

    @NotBlank
    @JSONField(name = "thirdPartyUserId")
    private String thirdPartyUserId;
    @NotBlank
    @JSONField(name = "name")
    private String name;
    @NotBlank
    @JSONField(name = "idType")
    private String idType;
    @NotBlank
    @JSONField(name = "idNumber")
    private String idNumber;
    @JSONField(name = "mobile")
    private String mobile;
    @JSONField(name = "email")
    private String email;
}
