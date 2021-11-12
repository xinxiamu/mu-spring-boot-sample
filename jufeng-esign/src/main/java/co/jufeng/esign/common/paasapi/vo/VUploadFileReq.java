package co.jufeng.esign.common.paasapi.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class VUploadFileReq implements Serializable {


    private static final long serialVersionUID = -8480577462589008106L;
    /**
     * contentMd5 : eGMHwA4TWnbg6PYKMxreUQ==
     * contentType : application/octet-stream
     * convert2Pdf : false
     * fileName : 附件.zip
     * fileSize : 2542635
     */

    @JSONField(name = "contentMd5")
    private String contentMd5;
    @JSONField(name = "contentType")
    private String contentType;
    @JSONField(name = "convert2Pdf")
    private Boolean convert2Pdf;
    @JSONField(name = "fileName")
    private String fileName;
    @JSONField(name = "fileSize")
    private Integer fileSize;
}
