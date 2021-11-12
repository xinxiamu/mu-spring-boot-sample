package co.jufeng.esign.api.vo.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
public class VDoSignReq implements Serializable {
    private static final long serialVersionUID = 433835140664323223L;


    /**
     * docs : [{"fileId":"368bf390517b452eba9c3c199f7652c8","fileName":"保理合同.pdf"}]
     * flowInfo : {"autoArchive":true,"autoInitiate":true,"businessScene":"狗日","contractRemind":1,"flowConfigInfo":{"noticeDeveloperUrl":"","redirectUrl":"","redirectDelayTime":0,"signPlatform":"1"},"remark":""}
     * signers : [{"signOrder":1,"signerAccount":{"signerAccountId":"","authorizedAccountId":""},"signfields":[{"autoExecute":false,"actorIndentityType":2,"posBean":{"posPage":"1","posX":440,"posY":440},"fileId":"368bf390517b452eba9c3c199f7652c8","sealType":1,"signType":1}]}]
     */

    @JsonProperty("flowInfo")
    private FlowInfoDTO flowInfo;
    @JsonProperty("docs")
    private List<DocsDTO> docs;
    @JsonProperty("signers")
    private List<SignersDTO> signers;

    @NoArgsConstructor
    @Data
    public static class FlowInfoDTO {
        /**
         * autoArchive : true
         * autoInitiate : true
         * businessScene : 狗日
         * contractRemind : 1
         * flowConfigInfo : {"noticeDeveloperUrl":"","redirectUrl":"","redirectDelayTime":0,"signPlatform":"1"}
         * remark :
         */

        /**
         * 默认自动归档
         */
        @JsonProperty("autoArchive")
        private Boolean autoArchive = true;
        /**
         * 自动开启
         */
        @JsonProperty("autoInitiate")
        private Boolean autoInitiate = true;
        /**
         * 文件主题
         *
         * 注：名称不支持以下9个字符：/ \ : * " < > | ？
         */
        @NotBlank
        @JsonProperty("businessScene")
        private String businessScene;
        /**
         * 文件到期前，提前多少小时回调提醒续签，小时（时间区间：1小时——15天），默认不提醒
         */
        @JsonProperty("contractRemind")
        private Integer contractRemind = 1;
        @JsonProperty("flowConfigInfo")
        private FlowConfigInfoDTO flowConfigInfo;
        @JsonProperty("remark")
        private String remark = "";

        @NoArgsConstructor
        @Data
        public static class FlowConfigInfoDTO {
            /**
             * noticeDeveloperUrl :
             * redirectUrl :
             * redirectDelayTime : 0
             * signPlatform : 1
             */

            /**
             * 通知开发者地址
             */
            @JsonProperty("noticeDeveloperUrl")
            private String noticeDeveloperUrl;
            /**
             * 签署完成重定向
             */
            @JsonProperty("redirectUrl")
            private String redirectUrl;
            @JsonProperty("redirectDelayTime")
            private Integer redirectDelayTime = 0;
            @JsonProperty("signPlatform")
            private String signPlatform = "1";
        }
    }

    @NoArgsConstructor
    @Data
    public static class DocsDTO {
        /**
         * fileId : 368bf390517b452eba9c3c199f7652c8
         * fileName : 保理合同.pdf
         */

        @JsonProperty("fileId")
        private String fileId;
        @JsonProperty("fileName")
        private String fileName;
    }

    @NoArgsConstructor
    @Data
    public static class SignersDTO {
        /**
         * signOrder : 1
         * signerAccount : {"signerAccountId":"","authorizedAccountId":""}
         * signfields : [{"autoExecute":false,"actorIndentityType":2,"posBean":{"posPage":"1","posX":440,"posY":440},"fileId":"368bf390517b452eba9c3c199f7652c8","sealType":1,"signType":1}]
         */

        @JsonProperty("signOrder")
        private Integer signOrder;
        @JsonProperty("signerAccount")
        private SignerAccountDTO signerAccount;
        @JsonProperty("signfields")
        private List<SignfieldsDTO> signfields;

        @NoArgsConstructor
        @Data
        public static class SignerAccountDTO {
            /**
             * signerAccountId :
             * authorizedAccountId :
             */

            @JsonProperty("signerAccountId")
            private String signerAccountId;
            @JsonProperty("authorizedAccountId")
            private String authorizedAccountId;
        }

        @NoArgsConstructor
        @Data
        public static class SignfieldsDTO {
            /**
             * autoExecute : false
             * actorIndentityType : 2
             * posBean : {"posPage":"1","posX":440,"posY":440}
             * fileId : 368bf390517b452eba9c3c199f7652c8
             * sealType : 1
             * signType : 1
             */

            @JsonProperty("autoExecute")
            private Boolean autoExecute = false;
            /**
             * 签署主体，1-个人签署；2-机构签署；
             */
            @JsonProperty("actorIndentityType")
            private Integer actorIndentityType;
            @JsonProperty("posBean")
            private PosBeanDTO posBean;
            /**
             * 待签署文件
             */
            @JsonProperty("fileId")
            private String fileId;
            /**
             * 默认模板印章签署
             */
            @JsonProperty("sealType")
            private Integer sealType = 1;
            /**
             * 单页签署。
             */
            @JsonProperty("signType")
            private Integer signType = 1;

            @NoArgsConstructor
            @Data
            public static class PosBeanDTO {
                /**
                 * posPage : 1
                 * posX : 440
                 * posY : 440
                 */

                /**
                 * 指定签署页码
                 */
                @JsonProperty("posPage")
                private String posPage;
                @JsonProperty("posX")
                private Integer posX;
                @JsonProperty("posY")
                private Integer posY;
            }
        }
    }
}
