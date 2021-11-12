package co.jufeng.esign.common.paasapi;

import co.jufeng.esign.common.paasapi.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class ESignIdentityServiceImpl extends ESignBaseService implements ESignIdentityService {

    @Override
    public VAccountPerson createByThirdPartyUserId(VAccountPersonReq req) {
        return httpCall(ApiPath.CREATE_BY_THIRD_PART_USER_ID, req, HttpMethod.POST, VAccountPerson.class, 53000000);
    }

    @Override
    public Resp delAccount(String accountId) {
        return httpCall(ApiPath.getDelAccountPath(accountId), null, HttpMethod.DELETE, Resp.class);
    }

    @Override
    public Telecom3Factors telecom3Factors(Telecom3FactorsReq req, String accountId) {
        return httpCall(ApiPath.getTelecom3Factors(accountId), req,  HttpMethod.POST, Telecom3Factors.class);
    }

    @Override
    public Resp telecom3FactorsAuthCode(AuthCodeReq req, String flowId) {
        return httpCall(ApiPath.getTelecom3FactorsAuth(flowId), req, HttpMethod.PUT, Resp.class);
    }

    @Override
    public VAccountOrg createByThirdPartyUserId(@Valid VAccountOrgReq req) {
        //53000000-机构已存在
        return httpCall(ApiPath.CREATE_BY_THIRD_PARTY_USER_ID, req, HttpMethod.POST, VAccountOrg.class, 53000000);
    }

    @Override
    public Resp delOrganizations(String orgId) {
        return httpCall(ApiPath.getDelOrgPath(orgId), null, HttpMethod.DELETE, Resp.class);
    }

    @Override
    public VFourFactors fourFactors(@Valid VFourFactorsReq req, String accountId) {
        return httpCall(ApiPath.getFourFactors(accountId), req, HttpMethod.POST, VFourFactors.class);
    }

    @Override
    public VSubbranch subbranch(String keyWord, String flowId) {
        Map<String, String> par = new HashMap<>();
        par.put("keyWord", keyWord);
        return httpCall(ApiPath.getSubbranch(flowId), par, VSubbranch.class);
    }

    @Override
    public Resp transferRandomAmount(@Valid VTransferRandomAmountReq req, String flowId) {
        return httpCall(ApiPath.getTransferRandomAmount(flowId), req, HttpMethod.PUT, Resp.class);
    }

    @Override
    public Resp verifyRandomAmount(@Valid VVerifyRandomAmountReq req, String flowId) {
        return httpCall(ApiPath.getVerifyRandomAmount(flowId), req, HttpMethod.PUT, Resp.class);
    }
}
