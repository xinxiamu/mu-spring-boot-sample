package co.jufeng.esign.api;

import co.jufeng.esign.api.vo.req.*;
import co.jufeng.esign.api.vo.resp.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("esignPaas")
public interface ESignPaasApi {

    /*========================= 个人实名认证 start ======================*/

    /**
     * 个人实名认证（运营商三要素）。
     * @param vo {@link VPersonalReq}
     * @return 认证成功返回e签宝调用服务的流水号
     */
    @PostMapping("/verifyPersonal")
    VVerifyPersonalResp verifyPersonal(@RequestBody @Validated VPersonalReq vo);

    /**
     * 实名认证手机验证码校验。
     * @param vo
     * @return
     */
    @PostMapping("/verifyPersonalAuth")
    Boolean verifyPersonalAuth(@RequestBody @Validated VVerifyPersonalAuthReq vo);

    /*========================= 个人实名认证 end ======================*/

    /*========================= 企业实名认证 start ======================*/

    /**
     * 第一步：发起企业实名认证4要素校验。
     * <p>1.创建企业账号。</p>
     * <p>2.四要数校验。</p>
     * @param vo
     * @return
     */
    @PostMapping("/verifyEtpFourFactors")
    VVerifyEtpFourFactorsResp verifyEtpFourFactors(@RequestBody @Validated VVerifyEtpReq vo);

    /**
     * 第二步：查询打款银行信息
     * @param flowId 流水号，在第一步返回。
     * @param keyWord 银行名称搜索关键字，建议输入完整的银行名称
     * @return
     */
    @GetMapping("/verifyEtpBankInfo")
    List<VVerifyEtpBankInfoResp> verifyEtpBankInfo(String flowId, String keyWord);

    /**
     * 第三步：对公打款。后台审核企业信息通过调用该接口。
     * @param req
     * @return
     */
    @PostMapping("/verifyEtpCheckAndPay")
    Boolean verifyEtpCheckAndPay(@RequestBody @Valid VVerifyEtpCheckAndPayReq req);

    /**
     * 第四步：对公打款金额校验
     * @param flowId 企业实名认证流程id
     * @param amount 企业对公账号收到的0.1-0.99的随机金额
     * @return
     */
    @PutMapping("/verifyEtpCheckPayMoney")
    Boolean verifyEtpCheckPayMoney(String flowId, double amount);

    //提示，企业实名认证成功后，前端直接调用接口创建企业印章

    /*========================= 企业实名认证 end ======================*/

    /**
     * 创建个人或者企业印章模板。
     * @param vo
     * @return
     */
    @PostMapping("/genSeals")
    VGenSealsResp genSeals(@RequestBody @Valid VGenSealsReq vo);

    /**
     * 上传文件
     * @param pdfFileUrl
     * @return
     */
    @GetMapping("/uploadPdfFile")
    String uploadPdfFile(@RequestParam String pdfFileUrl);

    /**
     * 查询文件详情/下载文件
     * @param fileId
     * @return
     */
    @GetMapping("/getFileInfo")
    ESignPdfFileInfoResp getFileInfo(@RequestParam String fileId);

    /**
     * 搜索文件关键字坐标。
     * @param fileId
     * @return
     */
    @GetMapping("/getFileKeyWordsPosition")
    List<VFileKeyWordsPositionResp> getFileKeyWordsPosition(@RequestParam String fileId, @RequestParam String keywords);

    /**
     * 创建一步签署服务流
     * @param req
     * @return
     */
    @PostMapping("/createSignFlow")
    VDoSignResp createSignFlow(@RequestBody VDoSignReq req);

    /**
     * 获取签署地址
     * @param flowId 流程号，一部签署接口返回。
     * @param accountId 签署经纪人账号
     * @param organizeId 企业机构账号
     * @return
     */
    @GetMapping("/getDoSigUrl")
    VDoSignUrlResp getDoSigUrl(@RequestParam String flowId, @RequestParam String accountId, @RequestParam String organizeId);

    /**
     * 获取签署文件。
     * @param flowId
     * @return
     */
    @GetMapping("/getSignFileInfo")
    List<VSignFileInfoResp> getSignFileInfo(@RequestParam String flowId);
}
