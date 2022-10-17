package com.example.demo.all;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AllDaoImpl implements AllDao {

    @Autowired
    @Qualifier("caffeineCacheManager")
    private CacheManager cacheManager;

    static Map userInfoMap;

    static {
        userInfoMap = new HashMap<Integer, UserInfo>();
    }

    @Override
    public UserInfo save(Integer userId, String userName, Integer age) {
        System.out.println("开始添加用户");
        userInfoMap.put(userId, new UserInfo(userId, userName, age));
        return (UserInfo) userInfoMap.get(userId);
    }

    @CachePut(cacheNames = "userInfo", key = "#root.methodName.#userId")
    @Override
    public UserInfo update(Integer userId, String userName) {
        System.out.println("开始更新用户");
        UserInfo userInfo = (UserInfo) userInfoMap.get(userId);
        userInfo.setName(userName);
        userInfoMap.put(userId, userInfo);
        return userInfo;
    }

//    @Cacheable(cacheNames = "userInfo", key = "#root.methodName.#userId") //@Cacheable(value = "userInfo")
    @Cacheable(cacheNames = "userInfo", keyGenerator = "myKeyGenerator") //myKeyGenerator为该bean的名称
    @Override
    public UserInfo get(Integer userId) {
        cacheManager.getCacheNames().forEach(s -> {
            System.out.println(">>>>cacheName:" + s);
        });
        System.out.println("获取用户信息:" + userId);
        return (UserInfo) userInfoMap.get(userId);
    }
}
