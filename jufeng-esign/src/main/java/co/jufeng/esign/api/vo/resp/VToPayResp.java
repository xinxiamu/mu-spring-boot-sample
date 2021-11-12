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
public class VToPayResp implements Serializable {


    /**
     * {
     * "errCode": 0,
     * "msg": null,
     * "serviceId": "11111-1111-1111-1111"
     * }
     */

    /**
     * 实名认证请求服务 ID，需要在打款验证时提供，用于唯一标
     * 识一次实名认证请求，成功时返回。实名认证成功或失效时，
     * 需要重新发起实名认证请求。
     */
    private String serviceId;
    /**
     * 错误码
     */
    private int errCode;
    /**
     * 错误信息
     */
    private String msg;
}
