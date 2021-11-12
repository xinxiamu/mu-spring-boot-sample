package co.jufeng.esign.common.paasapi.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class VPdfFileInfo implements Serializable {
    private static final long serialVersionUID = -6273683640740212028L;


    /**
     * code : 0
     * data : {"fileId":"","name":"","size":0,"status":0,"downloadUrl":"","pdfTotalPages":4}
     * message :
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
         * fileId :
         * name :
         * size : 0
         * status : 0
         * downloadUrl :
         * pdfTotalPages : 4
         */

        @JSONField(name = "fileId")
        private String fileId;
        @JSONField(name = "name")
        private String name;
        @JSONField(name = "size")
        private Integer size;
        @JSONField(name = "status")
        private Integer status;
        @JSONField(name = "downloadUrl")
        private String downloadUrl;
        @JSONField(name = "pdfTotalPages")
        private Integer pdfTotalPages;
    }
}
