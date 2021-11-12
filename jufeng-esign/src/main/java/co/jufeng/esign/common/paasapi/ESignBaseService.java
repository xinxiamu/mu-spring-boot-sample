package co.jufeng.esign.common.paasapi;

import co.jufeng.esign.common.APIs;
import co.jufeng.esign.common.Base;
import co.jufeng.esign.common.JwtUtils;
import co.jufeng.esign.common.RedisDao;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.time.Instant;
import java.util.Map;

@Slf4j
public abstract class ESignBaseService extends Base {

    protected static final String TOKEN_KEY = "esign.paas.key";

    @Autowired
    protected ConfigInfoProperties configInfoProperties;

    @Autowired
    protected RedisDao redisDao;

    String token() {
        String tokenOld = (String) redisDao.get(TOKEN_KEY);
        if (!StringUtils.isEmpty(tokenOld)) {
            Long timestamp = JwtUtils.getPubClaimValue(tokenOld, "timestamp", Long.class);
            if (Instant.ofEpochMilli(timestamp).plusMillis(1000 * 60 * 120).isAfter(Instant.now())) {
                return tokenOld;
            }
        }

        String token = TokenUtils.getToken(configInfoProperties.getUrl(), configInfoProperties.getAppId(), configInfoProperties.getSecret());
        redisDao.set(TOKEN_KEY, token);
        return token;
    }

    /*======================== okhttp3 start ==========================*/

    /**
     * get请求。
     * @param path
     * @param params 请求参数
     * @param tClass
     * @param notCheckCode
     * @param <T>
     * @return
     */
    <T> T httpCall(@NotNull String path, Map<String,String> params, Class<T> tClass, int ... notCheckCode) {
        HttpUrl.Builder httpBuilder = HttpUrl.parse(configInfoProperties.getUrl().concat(path)).newBuilder();
        if (params != null) {
            for(Map.Entry<String, String> param : params.entrySet()) {
                httpBuilder.addQueryParameter(param.getKey(),param.getValue());
            }
        }
        Request request = new Request.Builder()
                .url(httpBuilder.build())
                .addHeader("X-Tsign-Open-App-Id", configInfoProperties.getAppId())
                .addHeader("X-Tsign-Open-Token", token())
                .build();

        OkHttpClient okHttpClient = new OkHttpClient();
        try {
            Response resp = okHttpClient.newCall(request).execute();
            log.info("esign 请求：{}=结果：{}", path, resp.toString());

            if (tClass == String.class) {
                return (T) resp.body().string();
            }

            return toVResp(resp.body().string(), tClass, notCheckCode);
        } catch (IOException e) {
            log.error(">>>系统错误", e);
        }
        return null;
    }

    <T> T httpCall(@NotNull String path, @NotNull Object req, @NotNull HttpMethod httpMethod, Class<T> tClass, int ... notCheckCode) {
        OkHttpClient okHttpClient = new OkHttpClient();
        try {
            Request.Builder builder = requestBuilder(path);
            RequestBody body = requestBody(req);
            switch (httpMethod) {
                case POST:
                    builder.post(body);
                    break;
                case GET:
                    builder.get();
                    break;
                case PUT:
                    builder.put(body);
                    break;
                case DELETE:
                    MediaType contentType = body.contentType();
                    if (contentType.toString().equals("application/json;charset=UTF-8")) {
                        builder.delete(body);
                    } else {
                        builder.delete();
                    }
                    break;
            }

            Response resp = okHttpClient.newCall(builder.build()).execute();
            String respStr = resp.body().string();
            log.info("{}-esign 请求：{}=结果：{}", this.getClass().getSimpleName(), path, respStr);

            if (tClass == String.class) {
                return (T) respStr;
            }

            return toVResp(respStr, tClass, notCheckCode);
        } catch (IOException e) {
            log.error(">>>系统错误", e);
        }

        return null;
    }

    RequestBody requestBody(Object vo) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), JSONObject.toJSONString(vo));
        return requestBody;
    }

    Request.Builder requestBuilder(String path) {
        Request.Builder builder = new Request.Builder()
                .url(configInfoProperties.getUrl().concat(path))
                .addHeader("X-Tsign-Open-App-Id", configInfoProperties.getAppId())
                .addHeader("X-Tsign-Open-Token", token());
        return builder;
    }

    /*======================== okhttp3 end ==========================*/

    <T> T toVResp(String respStr, Class<T> tClass, int ... notCheckCode) {
        JSONObject respJson = JSONObject.parseObject(respStr);
        checkResp(respJson, notCheckCode);
        return JSONObject.toJavaObject(respJson, tClass);
    }

    private void checkResp(JSONObject respJson, int ... notCheckCodes) {
        int code = respJson.getIntValue("code");
        for (int notCheckCode: notCheckCodes) {
            if (code == notCheckCode) return;
        }
        String msg = respJson.getString("message");
        if (code != 0) {
            throw APIs.error(code, msg, null);
        }
    }
}
