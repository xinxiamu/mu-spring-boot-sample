package co.jufeng.esign.common.paasapi.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Resp {

    /**
     * code : 0
     * message : 成功
     */

    @JSONField(name = "code")
    private Integer code;
    @JSONField(name = "message")
    private String message;
}
