package co.jufeng.esign.api.vo.resp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 创建个人、企业模板印章返回结果对象。
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VAddSealResp extends Resp {
    private static final long serialVersionUID = 5020437827663862351L;

    /**
     * 电子印章图片base64数据
     */
    private String sealData;
}
