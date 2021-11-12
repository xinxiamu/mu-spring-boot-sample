package co.jufeng.esign.common.paasapi.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
public class VCreateFlowOneStepReq implements Serializable {
    private static final long serialVersionUID = -2935768158041495774L;


    /**
     * attachments : [{"attachmentName":"1","fileId":"ef08e9016806421e94f831a9d7012cb4"}]
     * docs : [{"fileId":"ef08e9016806421e94f831a9d7012cb4","fileName":"个人借贷合同.pdf"}]
     * copiers : [{"copierAccountId":"93659d99bdbf4ca4a019c61cab3e4eab","copierIdentityAccountId":"93659d99bdbf4ca4a019c61cab3e4eab","copierIdentityAccountType":0}]
     * flowInfo : {"autoArchive":true,"autoInitiate":true,"businessScene":"创建签署流程样例","contractRemind":1,"contractValidity":1601049600000,"flowConfigInfo":{"noticeDeveloperUrl":"http://101.37.27.38:1110/notice/signature","noticeType":"1,2,3","redirectUrl":"","signPlatform":"1,2"},"remark":"","signValidity":1601049600000}
     * signers : [{"platformSign":true,"signOrder":1,"signerAccount":{"signerAccountId":"a95132c8d0a64713a2b518945d745107","authorizedAccountId":"708617c289c4422d9deb0663940b8d80"},"signfields":[{"autoExecute":true,"actorIndentityType":2,"fileId":"ef08e9016806421e94f831a9d7012cb4","posBean":{"posPage":"1","posX":440,"posY":440},"sealType":"","signDateBean":{"fontSize":12,"format":"yyyy年MM日dd"},"signType":1,"width":150}],"thirdOrderNo":"111"}]
     */

    @JsonProperty("flowInfo")
    private FlowInfoDTO flowInfo;
    @JsonProperty("attachments")
    private List<AttachmentsDTO> attachments;
    @JsonProperty("docs")
    private List<DocsDTO> docs;
    @JsonProperty("copiers")
    private List<CopiersDTO> copiers;
    @JsonProperty("signers")
    private List<SignersDTO> signers;

    @NoArgsConstructor
    @Data
    public static class FlowInfoDTO {
        /**
         * autoArchive : true
         * autoInitiate : true
         * businessScene : 创建签署流程样例
         * contractRemind : 1
         * contractValidity : 1601049600000
         * flowConfigInfo : {"noticeDeveloperUrl":"http://101.37.27.38:1110/notice/signature","noticeType":"1,2,3","redirectUrl":"","signPlatform":"1,2"}
         * remark :
         * signValidity : 1601049600000
         */

        @JsonProperty("autoArchive")
        private Boolean autoArchive;
        @JsonProperty("autoInitiate")
        private Boolean autoInitiate;
        @JsonProperty("businessScene")
        private String businessScene;
        @JsonProperty("contractRemind")
        private Integer contractRemind;
        @JsonProperty("contractValidity")
        private Long contractValidity;
        @JsonProperty("flowConfigInfo")
        private FlowConfigInfoDTO flowConfigInfo;
        @JsonProperty("remark")
        private String remark;
        @JsonProperty("signValidity")
        private Long signValidity;

        @NoArgsConstructor
        @Data
        public static class FlowConfigInfoDTO {
            /**
             * noticeDeveloperUrl : http://101.37.27.38:1110/notice/signature
             * noticeType : 1,2,3
             * redirectUrl :
             * signPlatform : 1,2
             */

            @JsonProperty("noticeDeveloperUrl")
            private String noticeDeveloperUrl;
            @JsonProperty("noticeType")
            private String noticeType;
            @JsonProperty("redirectUrl")
            private String redirectUrl;
            @JsonProperty("signPlatform")
            private String signPlatform;
        }
    }

    @NoArgsConstructor
    @Data
    public static class AttachmentsDTO {
        /**
         * attachmentName : 1
         * fileId : ef08e9016806421e94f831a9d7012cb4
         */

        @JsonProperty("attachmentName")
        private String attachmentName;
        @JsonProperty("fileId")
        private String fileId;
    }

    @NoArgsConstructor
    @Data
    public static class DocsDTO {
        /**
         * fileId : ef08e9016806421e94f831a9d7012cb4
         * fileName : 个人借贷合同.pdf
         */

        @JsonProperty("fileId")
        private String fileId;
        @JsonProperty("fileName")
        private String fileName;
    }

    @NoArgsConstructor
    @Data
    public static class CopiersDTO {
        /**
         * copierAccountId : 93659d99bdbf4ca4a019c61cab3e4eab
         * copierIdentityAccountId : 93659d99bdbf4ca4a019c61cab3e4eab
         * copierIdentityAccountType : 0
         */

        @JsonProperty("copierAccountId")
        private String copierAccountId;
        @JsonProperty("copierIdentityAccountId")
        private String copierIdentityAccountId;
        @JsonProperty("copierIdentityAccountType")
        private Integer copierIdentityAccountType;
    }

    @NoArgsConstructor
    @Data
    public static class SignersDTO {
        /**
         * platformSign : true
         * signOrder : 1
         * signerAccount : {"signerAccountId":"a95132c8d0a64713a2b518945d745107","authorizedAccountId":"708617c289c4422d9deb0663940b8d80"}
         * signfields : [{"autoExecute":true,"actorIndentityType":2,"fileId":"ef08e9016806421e94f831a9d7012cb4","posBean":{"posPage":"1","posX":440,"posY":440},"sealType":"","signDateBean":{"fontSize":12,"format":"yyyy年MM日dd"},"signType":1,"width":150}]
         * thirdOrderNo : 111
         */

        @JsonProperty("platformSign")
        private Boolean platformSign;
        @JsonProperty("signOrder")
        private Integer signOrder;
        @JsonProperty("signerAccount")
        private SignerAccountDTO signerAccount;
        @JsonProperty("thirdOrderNo")
        private String thirdOrderNo;
        @JsonProperty("signfields")
        private List<SignfieldsDTO> signfields;

        @NoArgsConstructor
        @Data
        public static class SignerAccountDTO {
            /**
             * signerAccountId : a95132c8d0a64713a2b518945d745107
             * authorizedAccountId : 708617c289c4422d9deb0663940b8d80
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
             * autoExecute : true
             * actorIndentityType : 2
             * fileId : ef08e9016806421e94f831a9d7012cb4
             * posBean : {"posPage":"1","posX":440,"posY":440}
             * sealType :
             * signDateBean : {"fontSize":12,"format":"yyyy年MM日dd"}
             * signType : 1
             * width : 150
             */

            @JsonProperty("autoExecute")
            private Boolean autoExecute;
            @JsonProperty("actorIndentityType")
            private Integer actorIndentityType;
            @JsonProperty("fileId")
            private String fileId;
            @JsonProperty("posBean")
            private PosBeanDTO posBean;
            @JsonProperty("sealType")
            private String sealType;
            @JsonProperty("signDateBean")
            private SignDateBeanDTO signDateBean;
            @JsonProperty("signType")
            private Integer signType;
            @JsonProperty("width")
            private Integer width;

            @NoArgsConstructor
            @Data
            public static class PosBeanDTO {
                /**
                 * posPage : 1
                 * posX : 440
                 * posY : 440
                 */

                @JsonProperty("posPage")
                private String posPage;
                @JsonProperty("posX")
                private Integer posX;
                @JsonProperty("posY")
                private Integer posY;
            }

            @NoArgsConstructor
            @Data
            public static class SignDateBeanDTO {
                /**
                 * fontSize : 12
                 * format : yyyy年MM日dd
                 */

                @JsonProperty("fontSize")
                private Integer fontSize;
                @JsonProperty("format")
                private String format;
            }
        }
    }
}
