package co.jufeng.esign.common.paasapi.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class VSubbranch {

    /**
     * code : 0
     * message : 成功
     * data : {"list":[{"bankName":"平安银行杭州高新支行","bank":"平安银行","cnapsCode":"307331002584","city":"杭州市","province":"浙江"}]}
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
        @JSONField(name = "list")
        private List<ListDTO> list;

        @NoArgsConstructor
        @Data
        public static class ListDTO {
            /**
             * bankName : 平安银行杭州高新支行
             * bank : 平安银行
             * cnapsCode : 307331002584
             * city : 杭州市
             * province : 浙江
             */

            /**
             * 匹配支行完整名称
             */
            @JSONField(name = "bankName")
            private String bankName;
            /**
             * 匹配银行总行名称
             */
            @JSONField(name = "bank")
            private String bank;
            /**
             * 联行号信息
             */
            @JSONField(name = "cnapsCode")
            private String cnapsCode;
            /**
             * 支行所在市/区
             */
            @JSONField(name = "city")
            private String city;
            /**
             * 支行所在省份
             */
            @JSONField(name = "province")
            private String province;
        }
    }
}
