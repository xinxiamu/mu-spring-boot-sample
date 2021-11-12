package co.jufeng.esign.api.vo.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class VDoSignUrlResp implements Serializable {
    private static final long serialVersionUID = 7979258580391646709L;

    /**
     * url : http://testfront.tsign.cn:8821?context=mby8thwTJVcRhE8MbAUeYHiV0CoxNbGaCZz%2BzOIZxwPW8zZEyzddjDvu63OR%2BhpgEUp7Ys4DVub%2BiSQfldmCTC89MbdDHUUZ4yvgRXCjQ6s0Dcznr4daT4v9vR6SSKJsmrRIc%2F3xudxk6DmsqcmQSl0UJGwVCo%2FGFRG6bkjCuCSuVkESLfyf0iqgJqIuy8yYkxdWe%2Fi52IEJwFH%2FclDwS8Vb27mTop5HcuAAWaOUPKw2hTXCeLkx9zWgS4HOW17H8%2F%2BL6NtuWgiglUbedhpsdjgpEoQr63J%2FcXytIoFtDMvXmgZKnrN3QCuNBbS63QGuP5qHESNvyHbsd5qVkzy%2FzUSk7I4boumxkCFcDxXofKJ0SUahJTazovg031vx7uoXZT2kSW%2B9JhDN9rs8mbXCEs01VYiCiUP6hd81lHX%2B9jdFTJqELbE%2BDkBpUcCBJjbhME84qqoZDRTDHzQkxjOk3Ztbp3URjIFqpA9vAN%2FylLwzT0oyf3nirv7I%2BYBr8Qcr&flowId=b2cb74258a634179b0df3cc54791c8b6&organ=true
     * shortUrl : https://testt.tsign.cn/55vebd3omU7k
     */

    @JsonProperty("url")
    private String url;
    @JsonProperty("shortUrl")
    private String shortUrl;
}
