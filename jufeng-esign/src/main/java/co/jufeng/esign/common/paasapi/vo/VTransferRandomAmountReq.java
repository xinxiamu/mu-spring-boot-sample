package co.jufeng.esign.common.paasapi.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Data
public class VTransferRandomAmountReq {

    /**
     * province : 浙江
     * subbranch : 平安银行杭州高新支行
     * bank : 平安银行
     * city : 杭州市
     * cnapsCode : 307***2584
     * cardNo : 110034**75702
     * contextId : f0a7927d-c5f9-4652-a053-1130d86c8fa8
     * notifyUrl : http://172.20.62.10:8080/testnotify/msgRecive
     */

    /**
     * 对公账号开户行所在省份名称
     */
    @NotBlank
    @JSONField(name = "province")
    private String province;
    /**
     * 对公账号开户行支行名称全称
     */
    @NotBlank
    @JSONField(name = "subbranch")
    private String subbranch;
    /**
     * 对公账号开户行总行名称
     */
    @NotBlank
    @JSONField(name = "bank")
    private String bank;
    /**
     * 对公账号开户行所在城市名称
     */
    @NotBlank
    @JSONField(name = "city")
    private String city;
    /**
     * 联行号（名词解释） 可通过 查询打款银行信息 获取，或第三方数据库获取
     */
    @NotBlank
    @JSONField(name = "cnapsCode")
    private String cnapsCode;
    /**
     * 	银行卡号信息
     */
    @NotBlank
    @JSONField(name = "cardNo")
    private String cardNo;
    /**
     * 业务方业务上下文id，如果不填则取发起实名时的contextId
     */
    @JSONField(name = "contextId")
    private String contextId;
    /**
     * 打款成功后异步通知地址
     */
    @JSONField(name = "notifyUrl")
    private String notifyUrl;
}
