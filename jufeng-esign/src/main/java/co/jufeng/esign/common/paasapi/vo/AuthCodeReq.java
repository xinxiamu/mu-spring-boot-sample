package co.jufeng.esign.common.paasapi.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AuthCodeReq {

    /**
     * authcode : 123456
     */

    @JSONField(name = "authcode")
    private String authcode;
}
