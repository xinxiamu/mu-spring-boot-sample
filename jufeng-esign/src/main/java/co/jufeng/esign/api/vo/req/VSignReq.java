package co.jufeng.esign.api.vo.req;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VSignReq implements Serializable {

    private static final long serialVersionUID = -3465850095887756854L;

    /**
     * 文件存储id。
     */
    @NotNull
    private String url;

    /**
     * 文件名称。带上后缀.
     */
    @NotBlank
    private String fileName;

    /**
     * 签章描述
     */
    private String description;

    /**
     * 文档编辑密码，当目标PDF设置权限保护时必填
     */
    private String ownerPassword;

    private SignPos signPos;

    /**
     * 签章类型，Single（单页签章）、Multi（多页签章）、Edges（签骑缝章）、Key（关键字签章）
     */
    @NotBlank
    private String signType;

    /**
     * 签署账户标识
     */
    @NotBlank
    private String accountId;

    /**
     * 印章图片base64
     */
    @NotBlank
    private String sealData;

    /**
     * 接收短信验证码的手机
     */
    @NotBlank
    private String mobile;

    /**
     * 短信验证码
     */
    @NotBlank
    private String code;

    @Data
    public static class SignPos {

        /**
         * 签署页码, 若为多页签章，支持页码格式“1-3,5,8“, 坐标定位时不可空
         */
        private String posPage;

        /**
         * 定位类型，0坐标定位，1关键字定位，默认0（若为关键字定位，签章类型（signType）必须指定为关键字定位才生效）
         */
        private Integer posType;

        /**
         * 关键字
         */
        private String key;

        /**
         * 签署位置X坐标
         */
        private Float posX;

        /**
         * 签署位置Y坐标
         */
        private Float posY;

        /**
         * 印章展现高度
         */
        private Float width;

        /**
         * 是否是 二维码签署，默认为false。二维码签署不支持骑缝签和多页签
         */
        private Boolean qrcodeSign;

    }

}
