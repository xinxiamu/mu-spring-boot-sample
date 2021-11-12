package co.jufeng.esign.config;

import co.jufeng.esign.config.CustomObjectMapper;
import co.jufeng.esign.config.JsonHandlerExceptionResolver;
import co.jufeng.esign.config.JsonViewHttpMessageConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.hateoas.mediatype.hal.Jackson2HalModule;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.MediaTypes.HAL_JSON;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Value("${spring.application.name}")
    protected String appName;

    @Autowired
    private Environment env;

    @Bean
    public JsonViewHttpMessageConverter jsonViewHttpMessageConverter() {

        ObjectMapper objectMapper = new CustomObjectMapper();
        objectMapper.registerModule(new Jackson2HalModule());

        JsonViewHttpMessageConverter converter = new JsonViewHttpMessageConverter(Object.class);
        List<MediaType> list = new ArrayList<>();
        list.add(MediaType.APPLICATION_JSON);
        list.add(HAL_JSON);
        converter.setSupportedMediaTypes(list);
        converter.setObjectMapper(objectMapper);

        return converter;
    }


    @Override
    protected Validator getValidator() {
        return super.getValidator();
    }

    /**
     * 配置消息转换规则。
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //------json与对象转换器
        converters.add(jsonViewHttpMessageConverter());

        //-----字符串返回转换器
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        //解决返回乱码的问题。
        stringHttpMessageConverter.setSupportedMediaTypes(MediaType.parseMediaTypes("text/html;charset=UTF-8"));
        converters.add(stringHttpMessageConverter);

        //添加其它默认消息转换器
        super.addDefaultHttpMessageConverters(converters);
    }

    /**
     * 统一异常处理。
     * @param exceptionResolvers
     */
    @Override
    protected void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        exceptionResolvers.add(new JsonHandlerExceptionResolver(appName));
    }

    /**
     * 定义拦截器。
     *
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }


}
