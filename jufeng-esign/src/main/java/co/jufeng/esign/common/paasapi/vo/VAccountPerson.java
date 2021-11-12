package co.jufeng.esign.common.paasapi.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class VAccountPerson {


    /**
     * code : 0
     * data : {"accountId":"1c04a7****b664b5b1370e","idType":"CRED_PSN_CH_IDCARD","thirdPartyUserId":"2019****0111","mobile":"1826***xxxx","name":"张三","idNumber":"371xxxxxxxxxxxxxxx","email":"wu***st@tsign.com","thirdPartyUserType":"_DEFAULT_USER","status":false}
     * message : 成功
     */

    @JSONField(name = "code")
    private Integer code;
    @JSONField(name = "data")
    private DataDTO data;
    @JSONField(name = "message")
    private String message;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        /**
         * accountId : 1c04a7****b664b5b1370e
         * idType : CRED_PSN_CH_IDCARD
         * thirdPartyUserId : 2019****0111
         * mobile : 1826***xxxx
         * name : 张三
         * idNumber : 371xxxxxxxxxxxxxxx
         * email : wu***st@tsign.com
         * thirdPartyUserType : _DEFAULT_USER
         * status : false
         */

        @JSONField(name = "accountId")
        private String accountId;
        @JSONField(name = "idType")
        private String idType;
        @JSONField(name = "thirdPartyUserId")
        private String thirdPartyUserId;
        @JSONField(name = "mobile")
        private String mobile;
        @JSONField(name = "name")
        private String name;
        @JSONField(name = "idNumber")
        private String idNumber;
        @JSONField(name = "email")
        private String email;
        @JSONField(name = "thirdPartyUserType")
        private String thirdPartyUserType;
        @JSONField(name = "status")
        private Boolean status;
    }
}
