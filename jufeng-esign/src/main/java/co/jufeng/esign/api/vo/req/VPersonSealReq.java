package co.jufeng.esign.api.vo.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VPersonSealReq implements Serializable {

    private static final long serialVersionUID = 2992599629494343374L;

    /**
     * 待创建印章的账户标识
     */
    @NotBlank
    private String accountId;

    /**
     * 模板类型。
     * <li>SQUARE       正方形印章</li>
     * <li>RECTANGLE    矩形印章</li>
     * <li>FZKC         艺术字体印章</li>
     * <li>YYGXSF       艺术字体印章</li>
     * <li>HYLSF        艺术字体印章</li>
     * <li>BORDERLESS   无框矩形印章</li>
     * <li>HWLS         华文隶书</li>
     * <li>HWXK         华文行楷</li>
     * <li>HWXKBORDER   带框华文行楷</li>
     * <li>YGYJFCS      叶根友疾风草书</li>
     * <li>YGYMBXS      叶根友行书</li>
     */
    @NotBlank
    private String personTemplateType;

    /**
     * 生成印章的颜色.
     *  <li>RED       红色</li>
     *  <li>BLUE    蓝色</li>
     *  <li>BLACK     黑色</li>
     */
    @NotBlank
    private String sealColor;
}
