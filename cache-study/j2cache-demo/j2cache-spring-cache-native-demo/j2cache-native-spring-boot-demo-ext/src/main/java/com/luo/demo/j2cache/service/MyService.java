package com.luo.demo.j2cache.service;

import com.luo.demo.j2cache.bean.MyObj;
import lombok.extern.slf4j.Slf4j;
import net.oschina.j2cache.CacheChannel;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@CacheConfig(cacheNames = MyService.CACHE_NAME)
@Slf4j
public class MyService {

    protected static final String CACHE_NAME = "myRegion";

    /**
     * J2Cache依赖
     */
    @Resource
    private CacheChannel cacheChannel;

    /**
     * Spring CacheManager依赖
     */
    @Resource
    private CacheManager cacheManager;

    public AtomicInteger num = new AtomicInteger(0);

    public void resetNum() {
        num = new AtomicInteger(0);
    }
    @Cacheable(key = "#id")
    public MyObj getMyObj(Long id) {
        MyObj myObj = MyObj.builder()
                .id(id)
                .name("myObj_" + id)
                .num(num.incrementAndGet())
                .date(new Date())
                .localDateTime(LocalDateTime.now())
                .build();
        log.info("[GET] getMyObj: {}", myObj);
        return myObj;
    }

    @CacheEvict(key = "#myObj.id")
    public Integer updateMyObj(MyObj myObj) {
        myObj.setNum(num.incrementAndGet());
        myObj.setDate(new Date());
        myObj.setLocalDateTime(LocalDateTime.now());
        log.info("[SET] updateMyObj: {}", myObj);
        return 1;
    }

    @CachePut(key = "#myObj.id")
    public MyObj updateMyObjWithReturn(MyObj myObj) {
        myObj.setNum(num.incrementAndGet());
        myObj.setDate(new Date());
        myObj.setLocalDateTime(LocalDateTime.now());
        log.info("[SET] updateMyObj: {}", myObj);
        return myObj;
    }

    @CacheEvict(key = "#id")
    public Integer deleteMyObj(Long id) {
        log.info("[EVICT] deleteMyObj By Id: {}", id);
        return 1;
    }


    @CacheEvict(allEntries = true)
    public Integer deleteAllMyObj() {
        Collection<String> keys = this.cacheChannel.keys(MyService.CACHE_NAME);
        log.info("[CLEAR] deleteAllMyObj keys: {}", keys);
        return keys.size();
    }

}
