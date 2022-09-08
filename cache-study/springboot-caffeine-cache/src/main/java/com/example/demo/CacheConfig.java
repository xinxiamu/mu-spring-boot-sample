package com.example.demo;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

    /**
     * 配置缓存管理器
     * @return 缓存管理器
     */
    @Bean("caffeineCacheManager")
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(Caffeine.newBuilder()
                // 最后一次写入后经过固定时间过期300秒
                .expireAfterWrite(20, TimeUnit.SECONDS)
                // 初始的缓存空间大小
                .initialCapacity(100)
                // 缓存的最大条数
                .maximumSize(1000));
        return cacheManager;
    }

    /**
     * 相当于在构建LoadingCache对象的时候 build()方法中指定过期之后的加载策略方法
     * 必须要指定这个Bean，refreshAfterWrite=60s属性才生效
     * @return
     */
    /*@Bean
    public CacheLoader<String, Object> cacheLoader() {
        CacheLoader<String, Object> cacheLoader = new CacheLoader<String, Object>() {
            @Override
            public Object load(String key) throws Exception {
                return null;
            }
            // 重写这个方法将oldValue值返回回去，进而刷新缓存
            @Override
            public Object reload(String key, Object oldValue) throws Exception {
                return oldValue;
            }
        };
        return cacheLoader;
    }

    @Bean
    public Cache<String, Object> cache(CacheLoader<String, Object> cacheLoader) {
        return Caffeine.newBuilder()
                // 创建缓存或者最近一次更新缓存后经过固定的时间间隔，刷新缓存 最后一次写入后经过固定时间过期
                .refreshAfterWrite(5, TimeUnit.SECONDS)
                // 初始的缓存空间大小
                .initialCapacity(100)
                // 缓存的最大条数
                .maximumSize(10000)
                //软引用
                .softValues()
                .build(cacheLoader);
    }*/
}
