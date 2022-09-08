package com.example.demo.test1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class InterlibServiceImpl implements InterlibService {

    private static final Logger logger = LoggerFactory.getLogger(InterlibServiceImpl.class);

    @Override
    @Cacheable(cacheNames = "caffeineCacheManager", key = "#root.targetClass.simpleName+'-getSessionId'", unless = "!#result.success")
    public Result<String> getSessionId() {
//        logger.info("为id、key为:" + p.getId() + "数据做了缓存");
        System.out.println("获取数据");
        return new Result(200, "查询成功", "12321312");
    }
}
