package co.jufeng.esign.api.vo.resp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VGenSealsResp implements Serializable {
    private static final long serialVersionUID = 877450425314181260L;

    /**
     * sealId : 15ebf9e7-f1f3-423f-b155-f1806236464e
     * fileKey : $216f8325-2714-42b8-8381-94c53c984b02$3368092071
     * url : https://esignoss.oss-cn-hangzhou.aliyuncs.com/seal-service/e9cf6332-a728-4724-bab3-117880883f59/783f31c3-d3f3-45e0-8f84-be9f51331906-openseal.png?Expires=1569311449&OSSAccessKeyId=LTAIdvHfiVrzDKbE&Signature=7TA%2BPsd4p59fyDsgT2IxUCXPxJM%3D
     * width : 100
     * height : 100
     */

    private String sealId;
    private String fileKey;
    private String url;
    private Integer width;
    private Integer height;
}
