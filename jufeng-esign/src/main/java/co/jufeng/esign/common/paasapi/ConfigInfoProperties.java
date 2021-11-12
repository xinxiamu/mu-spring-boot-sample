package co.jufeng.esign.common.paasapi;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 跨域配置信息对象。
 */
@Configuration
@ConfigurationProperties(prefix = "esign.paasapi")
public class ConfigInfoProperties {

    /**
     * 请求域名地址。
     */
    private String url;
    /**
     * appId
     */
    private String appId;
    /**
     * 密钥
     */
    private String secret;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
