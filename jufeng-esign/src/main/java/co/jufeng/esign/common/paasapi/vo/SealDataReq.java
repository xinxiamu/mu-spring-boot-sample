package co.jufeng.esign.common.paasapi.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SealDataReq {

    /**
     * alias : 芜浣的机构印章别名
     * central : STAR
     * color : RED
     * height : 100
     * width : 50
     * htext : 横向文
     * qtext : 下弦文
     * type : TEMPLATE_ROUND
     */

    @JSONField(name = "alias")
    private String alias;
    @JSONField(name = "central")
    private String central;
    @JSONField(name = "color")
    private String color;
    @JSONField(name = "height")
    private Integer height;
    @JSONField(name = "width")
    private Integer width;
    @JSONField(name = "htext")
    private String htext;
    @JSONField(name = "qtext")
    private String qtext;
    @JSONField(name = "type")
    private String type;

    /**
     * 个人或者企业账号id。
     */
    private String accountId;
}
