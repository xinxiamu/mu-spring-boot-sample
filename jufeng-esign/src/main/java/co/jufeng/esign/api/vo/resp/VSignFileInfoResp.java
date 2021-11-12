package co.jufeng.esign.api.vo.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class VSignFileInfoResp implements Serializable {
    private static final long serialVersionUID = 8051589357981620427L;


    /**
     * fileId : 01e50a9cedb74493a2d320b4f4732a29
     * fileName : 第一份合同.pdf
     * fileUrl : https://esignoss.oss-cn-hangzhou.aliyuncs.com/1111563786/4a68f87e-9a65-4dbc-84f4-8880da388aa4/%E5%8A%B3%E5%8A%A8%E5%90%88%E5%90%8C%E4%B9%A6.pdf?Expires=1560774752&OSSAccessKeyId=LTAIdvHfiVrzDKbE&Signature=rxDqsTOGuRA6NwKvneYlqKDFnS4%3D
     */

    @JsonProperty("fileId")
    private String fileId;
    @JsonProperty("fileName")
    private String fileName;
    @JsonProperty("fileUrl")
    private String fileUrl;
}
