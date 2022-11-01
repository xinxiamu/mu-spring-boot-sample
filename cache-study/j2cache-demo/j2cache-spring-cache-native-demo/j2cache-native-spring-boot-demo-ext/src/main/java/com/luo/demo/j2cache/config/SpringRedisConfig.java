package com.luo.demo.j2cache.config;

import io.lettuce.core.ReadFrom;
import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisStaticMasterReplicaConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

/**
 * Spring Redis配置
 *
 * @author luohq
 * @date 2022-04-08 15:42
 */
@Configuration
public class SpringRedisConfig {

    /**
     * 开启Lettuce客户端读写分离配置（Write to Master, Read from Replica）
     */
    @Bean
    public LettuceClientConfigurationBuilderCustomizer lettuceClientConfigurationBuilderCustomizer() {
        return lettuceClientConfigurationBuilder -> {
            //从replica进行read操作（若replica不可用则回退到从master执行read操作）
            lettuceClientConfigurationBuilder.readFrom(ReadFrom.REPLICA_PREFERRED);
        };
    }

    ///**
    // * 自定义Lettuce连接工厂，
    // * 静态指定Redis节点信息，
    // * 开启Lettuce客户端读写分离配置（Write to Master, Read from Replica）
    // */
    //@Bean
    //public LettuceConnectionFactory redisConnectionFactory() {
    //    LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
    //            //从replica进行read操作（若replica不可用则回退到从master执行read操作）
    //            .readFrom(ReadFrom.REPLICA_PREFERRED)
    //            .build();
    //    //静态指定Redis节点连接信息（声明时可先指定Master节点信息）
    //    RedisStaticMasterReplicaConfiguration staticMasterReplicaConfiguration = new RedisStaticMasterReplicaConfiguration("192.168.3.101", 6379);
    //    staticMasterReplicaConfiguration.setPassword("mypassw123456");
    //    //添加其他Replica节点信息
    //    staticMasterReplicaConfiguration.addNode("192.168.3.102", 6381);
    //    return new LettuceConnectionFactory(staticMasterReplicaConfiguration, clientConfig);
    //}


}
