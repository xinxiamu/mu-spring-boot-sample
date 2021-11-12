package co.jufeng.esign.common.paasapi;

import co.jufeng.esign.common.APIs;
import co.jufeng.esign.common.HttpsUtils;
import co.jufeng.esign.common.paasapi.vo.TokenInfo;
import com.alibaba.fastjson.JSONObject;

import javax.validation.constraints.NotNull;

public final class TokenUtils {

    public static String getToken(@NotNull String url, @NotNull String appId, @NotNull String secret) {
        String contentStr = HttpsUtils.create(url.concat(ApiPath.getTokenPath(appId, secret))).get().getContentAsString();
        TokenInfo tokenInfo = JSONObject.toJavaObject(JSONObject.parseObject(contentStr), TokenInfo.class);
        if (tokenInfo.getCode() != 0) {
            throw APIs.error(tokenInfo.getCode(), tokenInfo.getMessage(), null);
        }
        String token = tokenInfo.getData().getToken();
        return token;
    }
}
