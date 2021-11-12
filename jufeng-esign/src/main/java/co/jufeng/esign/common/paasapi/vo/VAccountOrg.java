package co.jufeng.esign.common.paasapi.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class VAccountOrg {

    /**
     * code : 0
     * message : 成功
     * data : {"orgId":"277f63ca9c0a43b594b40b28a1614aff"}
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
         * orgId : 277f63ca9c0a43b594b40b28a1614aff
         */

        @JSONField(name = "orgId")
        private String orgId;
    }
}
