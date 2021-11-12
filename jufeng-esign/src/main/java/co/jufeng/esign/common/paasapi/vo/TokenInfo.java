package co.jufeng.esign.common.paasapi.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TokenInfo {

    /**
     * code : 0
     * message : 成功
     * data : {"expiresIn":"1611899803143","token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJnSWQiOiI5ZGNhNTlkYTk0MjY0ODA1OWE4MmI0NGVhYjc0MDhkNiIsImFwcElkIjoiNzQzODg0MTQ5OCIsIm9JZCI6IjY0ZTQxMDg4NmI3OTQ0ODM4M2VhOWYwOGEzZGY2ODRlIiwidGltZXN0YW1wIjoxNjExODkyNjAzMTQxfQ.etBXyPfUlDmZ6E2jTCGSptvVvaNyS0tRh6QGWyMkaVc","refreshToken":"4e58f068f30f69f8262dbb9a8b694e41"}
     */

    @JSONField(name = "code")
    private Integer code;
    @JSONField(name = "message")
    private String message;
    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        /**
         * expiresIn : 1611899803143
         * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJnSWQiOiI5ZGNhNTlkYTk0MjY0ODA1OWE4MmI0NGVhYjc0MDhkNiIsImFwcElkIjoiNzQzODg0MTQ5OCIsIm9JZCI6IjY0ZTQxMDg4NmI3OTQ0ODM4M2VhOWYwOGEzZGY2ODRlIiwidGltZXN0YW1wIjoxNjExODkyNjAzMTQxfQ.etBXyPfUlDmZ6E2jTCGSptvVvaNyS0tRh6QGWyMkaVc
         * refreshToken : 4e58f068f30f69f8262dbb9a8b694e41
         */

        @JSONField(name = "expiresIn")
        private String expiresIn;
        @JSONField(name = "token")
        private String token;
        @JSONField(name = "refreshToken")
        private String refreshToken;
    }
}
