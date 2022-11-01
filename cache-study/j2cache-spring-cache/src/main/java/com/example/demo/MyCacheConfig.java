//package com.example.demo;
//
//import net.oschina.j2cache.J2CacheBuilder;
//import net.oschina.j2cache.J2CacheConfig;
//import net.oschina.j2cache.springcache.J2CacheSpringCacheManageAdapter;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.IOException;
//
//@Configuration
//@EnableCaching
//public class MyCacheConfig extends CachingConfigurerSupport {
//
//    @Override
//    public CacheManager cacheManager() {
//        // 引入配置
//        J2CacheConfig config = null;
//        try {
//            config = J2CacheConfig.initFromConfig("/j2cache.properties");
//            // 生成 J2CacheBuilder
//            J2CacheBuilder j2CacheBuilder = J2CacheBuilder.init(config);
//            // 构建适配器
//            J2CacheSpringCacheManageAdapter j2CacheSpringCacheManageAdapter = new J2CacheSpringCacheManageAdapter(j2CacheBuilder, true);
//
//            return j2CacheSpringCacheManageAdapter;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
