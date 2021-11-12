package co.jufeng.esign.common.paasapi.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class Telecom3Factors implements Serializable {

    /**
     * code : 0
     * message : 成功
     * data : {"flowId":"1634333731021940447"}
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
         * flowId : 1634333731021940447
         */

        @JSONField(name = "flowId")
        private String flowId;
    }
}
