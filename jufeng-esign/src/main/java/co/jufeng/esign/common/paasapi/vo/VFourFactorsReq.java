package co.jufeng.esign.common.paasapi.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Data
public class VFourFactorsReq {

    /**
     * agentAccountId :
     * repetition : true
     * contextId :
     * notifyUrl :
     * frAuthEnable : false
     */

    /**
     * 办理人账号Id，通过创建个人账号接口获取，要求办理人账号ID已完成个人实名认证。
     */
    @NotBlank
    @JSONField(name = "agentAccountId")
    private String agentAccountId;
    /**
     * 是否允许账号重复实名。默认允许重复实名
     */
    @JSONField(name = "repetition")
    private Boolean repetition;
    /**
     * 	对接方业务上下文id，将在异步通知及跳转时携带返回对接方
     */
    @JSONField(name = "contextId")
    private String contextId;
    /**
     * 认证结束后异步通知地址
     */
    @JSONField(name = "notifyUrl")
    private String notifyUrl;
    /**
     *
     * 是否需要进行法定代表人认证判断，默认false
     *
     * true：开启；
     *
     * false：关闭。
     *
     * 如开启的话，系统判断办理人为法定代表人本人操作，则企业实名直接完成认证，不需要再做对公打款/法人授权
     */
    @JSONField(name = "frAuthEnable")
    private Boolean frAuthEnable;
}
