package com.example.demo.all;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AllDaoImpl implements AllDao {

    static Map userInfoMap;

    static {
        userInfoMap = new HashMap<Integer, UserInfo>();
    }

    @CacheEvict(cacheNames = "user", key = "#root.target.#userId") //缓存失效，添加后，同时删除该key的缓存
    @Override
    public UserInfo save(Integer userId, String userName, Integer age) {
        System.out.println("开始添加用户");
        userInfoMap.put(userId, new UserInfo(userId, userName, age));
        return (UserInfo) userInfoMap.get(userId);
    }

    //添加缓存注解CachePut，表示更新底层数据库数据后，接着更新该key的缓存
    @CachePut(cacheNames = "user", key = "#root.target.#userId")
    @Override
    public UserInfo update(Integer userId, String userName) {
        System.out.println("开始更新用户");
        UserInfo userInfo = (UserInfo) userInfoMap.get(userId);
        userInfo.setName(userName);
        userInfoMap.put(userId, userInfo);
        return userInfo;
    }

//    @Cacheable(cacheNames = "user", key = "#root.methodName.#userId") //属性unless表示，当用户id不等于2的写入缓存
    @Cacheable(cacheNames = "user", key = "#root.targetClass.methods.#userId") //属性unless表示，当用户id不等于2的写入缓存
    @Override
    public UserInfo get(Integer userId) {
        System.out.println("获取用户信息:" + userId);
        return (UserInfo) userInfoMap.get(userId);
    }
}
