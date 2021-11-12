package co.jufeng.esign.api.vo.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * 企业认证对公打款传输对象。
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VToPayReq implements Serializable {

    private static final long serialVersionUID = -8134614478638808997L;

    /*
        {
            "name": "杭州天谷信息科技有限公司",
            "cardno": "11003491675701",
            "subbranch": "平安银行杭州高新支行",
            "bank": "平安银行",
            "provice": "浙江省",
            "city": "杭州市",
            "notify": "www.tsign.cn",
            "serviceId": "11111-1111-1111-1111",
            "prcptcd": "***********"
        }
     */

    /**
     * 对公账户户名（一般来说即企业名称）
     */
    @NotBlank
    private String name;
    /**
     * 企业对公银行账号。
     */
    @NotBlank
    private String cardno;
    /**
     * 企业银行账号开户行支行全称。
     */
    @NotBlank
    private String subbranch;
    /**
     * 企业银行账号开户行名称，支持银行列表见《e 签宝企业实名
     * 认证服务支持打款银行列表》，精确匹配
     */
    @NotBlank
    private String bank;
    /**
     * 企业银行账号开户行所在省份，支持省份见《e 签宝企业实名
     * 认证服务银行省市列表》，精确匹配
     */
    @NotEmpty
    private String provice;
    /**
     * 企业银行账号开户行所在城市，支持县市见《e 签宝企业实名
     * 认证服务银行省市列表》，精确匹配
     */
    @NotBlank
    private String city;
    /**
     * 企业信息校验成功后返回的 serviceId
     */
    @NotBlank
    private String serviceId;
    /**
     * 企业用户对公账户所在的开户行的大额行号；请参考 3 附录
     * 备用渠道免传银行行号银行列表。列表内银行不必传入
     * 大额行号，其他银行需要传入大额行号，备用渠道 prcptcd 为
     * 必填
     */
    @NotBlank
    private String prcptcd;
    /**
     * 打款完成通知的接收地址
     */
    private String notify;
    /**
     * 调用者业务 ID
     */
    private String pizId;
}
