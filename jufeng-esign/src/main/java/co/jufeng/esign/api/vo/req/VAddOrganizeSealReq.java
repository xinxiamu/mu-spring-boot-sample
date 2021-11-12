package co.jufeng.esign.api.vo.req;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class VAddOrganizeSealReq implements Serializable {


    private static final long serialVersionUID = 9113301418228482894L;

    /**
     * accountId : 283D608DD4DB4F389C72440625610F32
     * color : RED
     * templateType : STAR
     * hText : 横向文
     * qText : 下弦文
     */

    /**
     *待创建印章的账户标识
     */
    @NotBlank
    private String accountId;
    /**
     * 生成印章的颜色，RED（红色）、BLACK（黑色）、BLUE（蓝色）
     */
    @NotBlank
    private String color;
    /**
     * 模板类型，STAR（标准公章），OVAL（椭圆形印章）
     */
    @NotBlank
    private String templateType;
    /**
     * 生成印章中的横向文内容
     */
    private String hText;
    /**
     * 生成印章中的下弦文内容
     */
    private String qText;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public String getHText() {
        return hText;
    }

    public void setHText(String hText) {
        this.hText = hText;
    }

    public String getQText() {
        return qText;
    }

    public void setQText(String qText) {
        this.qText = qText;
    }
}
