package co.jufeng.esign.api.vo.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VPersonalReq implements Serializable {

    private static final long serialVersionUID = -405482692074055282L;


    /**
     * mobile : 13717899496
     * name : 王呈祥
     * idno : 130929198309068490
     * thirdPartyUserId: 130929198309068490  用户id
     */

    /**
     * 手机号码。TODO 添加正常表达式校验
     */
    @NotBlank
    @Size(min = 11, max = 11)
    private String mobile;
    /**
     * 真实姓名。
     */
    @NotBlank
    @Size(min = 2)
    private String name;
    /**
     * 省份证号码。TODO 添加正常表达式校验
     */
    @NotBlank
    private String idno;

    private String thirdPartyUserId;
}
