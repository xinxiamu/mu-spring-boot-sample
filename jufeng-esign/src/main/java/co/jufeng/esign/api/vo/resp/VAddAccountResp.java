package co.jufeng.esign.api.vo.resp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VAddAccountResp extends Resp {
    private static final long serialVersionUID = 5009843134476459732L;

    /**
     * 账户标识
     */
    private String accountId;
    /**
     * 指定创建指纹证书时返回的指纹信息
     */
    private String fingerprint;
}
