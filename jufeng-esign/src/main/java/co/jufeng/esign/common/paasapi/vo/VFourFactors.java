package co.jufeng.esign.common.paasapi.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class VFourFactors {

    /**
     * code : 0
     * message : 成功
     * data : {"flowId":"836551334533533698"}
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
         * flowId : 836551334533533698
         */

        @JSONField(name = "flowId")
        private String flowId;
    }
}
