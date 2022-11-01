package com.luo.demo.j2cache.base;

import lombok.extern.slf4j.Slf4j;
import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.CacheObject;
import net.oschina.j2cache.J2CacheBuilder;
import net.oschina.j2cache.J2CacheConfig;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * J2cache L1 Caffeine缓存示例
 *
 * @author luohq
 * @date 2022-04-03 11:57
 */
@Slf4j
public class J2CacheBaseSample {

    public static final String COMMA_STR = ",";
    public static final String DEFAULT_REGION = "myRegion";
    public static final String DEFAULT_KEY1 = "myKey1";
    public static final String DEFAULT_KEY2 = "myKey2";
    public static final Function<String, Object> DEFAULT_LOADER = key -> {
        List<MyObjInner> myObjInnerList = LongStream.of(1, 2, 3)
                .mapToObj(id -> MyObjInner.builder()
                        .id(id)
                        .name(String.format("myObjInner_%s_%d", key, id))
                        .build())
                .collect(Collectors.toList());
        MyObj myObj = MyObj.builder()
                .id(1L)
                .name(String.format("myObj_%s_%d", key, 1))
                .date(new Date())
                .localDateTime(LocalDateTime.now())
                .myObjInnerList(myObjInnerList)
                .build();
        log.info("[LOAD] obj: {}", myObj);
        return myObj;
    };


    private final CacheChannel cacheChannel;

    public J2CacheBaseSample(String j2CachePropsPath) throws IOException {
        J2CacheConfig j2CacheConfig = J2CacheConfig.initFromConfig(j2CachePropsPath);
        J2CacheBuilder j2CacheBuilder = J2CacheBuilder.init(j2CacheConfig);
        cacheChannel = j2CacheBuilder.getChannel();
    }

    public void setCache(String region, String key, Object value) {
        log.info("[SET] region: {}, key: {}, value: {}", region, key, value);
        this.cacheChannel.set(region, key, value);
    }

    public <T> T getCache(String region, String key) {
        CacheObject cacheObject = this.cacheChannel.get(region, key);
        log.info("[GET] region: {}, key: {}, value: {}", region, key, cacheObject);
        return (T) cacheObject.getValue();
    }

    public <T> T getCacheWithLoader(String region, String key, Function<String, Object> loader) {
        CacheObject cacheObject = this.cacheChannel.get(region, key, loader);
        log.info("[GET WITH LOADER] region: {}, key: {}, value: {}", region, key, cacheObject);
        return (T) cacheObject.getValue();
    }

    public void evict(String region, String... keys) {
        log.info("[EVICT] region: {}, keys: {}", region, String.join(COMMA_STR, keys));
        this.cacheChannel.evict(region, keys);
    }

    public void clear(String region) {
        log.info("[CLEAR] region: {}", region);
        this.cacheChannel.clear(region);
    }

    public Collection<String> keys(String region) {
        Collection<String> keys = this.cacheChannel.keys(region);
        log.info("[KEYS] region: {}, keys: {}", region, keys);
        return keys;
    }


    /**
     * 测试缓存（使用默认定义）
     *
     * @throws Exception
     */
    public void test() throws Exception {
        this.test(DEFAULT_REGION, DEFAULT_KEY1, DEFAULT_KEY2, DEFAULT_LOADER);
    }

    /**
     * 测试缓存
     *
     * @param region 区域（对应缓存名）
     * @param key1   缓存key名称1
     * @param key2   缓存key名称2
     * @param loader 缓存对应的加载器
     * @throws Exception
     */
    public void test(String region, String key1, String key2, Function<String, Object> loader) throws Exception {
        //查询缓存（若值不存在则通过loader加载，并写会1、2级缓存）
        Object myObj1 = this.getCacheWithLoader(region, key1, loader);

        //TODO DElETE
        Thread.sleep(10000);

        Object myObj2 = DEFAULT_LOADER.apply(key2);
        //设置缓存
        this.setCache(region, key2, myObj2);

        //查询缓存
        myObj1 = this.getCache(region, key1);
        myObj2 = this.getCache(region, key2);

        //获取缓存中全部keys
        Collection<String> keys = this.keys(region);

        //删除key
        this.evict(region, key1);
        this.keys(region);

        //清除region下全部keys
        this.clear(region);
        this.keys(region);
    }

    /**
     * 测试缓存
     *
     * @param region 区域（对应缓存名）
     * @param key1   缓存key名称1
     * @throws Exception
     */
    public void test2(String region, String key1) throws Exception {
        //查询缓存（若值不存在则通过loader加载，并写会1、2级缓存）
        Object myObj1 = this.getCache(region, key1);

        //TODO DElETE
        Thread.sleep(20000);
    }


}
