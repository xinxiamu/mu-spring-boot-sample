package co.jufeng.esign.common.paasapi.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class VCreateFlowOneStep implements Serializable {
    private static final long serialVersionUID = 7699815084084465801L;


    /**
     * code : 0
     * message : 成功
     * data : {"flowId":"bd465171b2a84434ad80bf416957c9aa"}
     */

    @JsonProperty("code")
    private Integer code;
    @JsonProperty("message")
    private String message;
    @JsonProperty("data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        /**
         * flowId : bd465171b2a84434ad80bf416957c9aa
         */

        @JsonProperty("flowId")
        private String flowId;
    }
}
