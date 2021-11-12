package co.jufeng.esign.api.vo.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 企业认证对公打款传输对象。
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VPayAuthReq implements Serializable {

    private static final long serialVersionUID = -8134614478638808997L;

    /*
        {
            "serviceId": "11111-1111-1111-1111"
            "cash": 0.5
        }
    */

    /**
     * 接口{@link com.xrlj.serviceesign.api.ESignApi} verifyEnterprise返回的服务ID。
     * <p/>实名认证成功或失效时，需要重新发起实名认证请求。
     */
    @NotBlank
    private String serviceId;
    /**
     * 打款金额
     */
    @NotNull
    private Float cash;
}
