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
public class VPayAuthResp implements Serializable {


    /**
     * {
     * "errCode": 0,
     * "msg": null,
     * }
     */

    /**
     * 错误码
     */
    private int errCode;
    /**
     * 错误信息
     */
    private String msg;
}
