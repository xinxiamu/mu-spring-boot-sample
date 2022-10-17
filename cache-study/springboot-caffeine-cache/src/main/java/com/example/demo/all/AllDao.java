package com.example.demo.all;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

public interface AllDao {

    UserInfo save(Integer userId, String userName, Integer age);

    /**
     * 更新。总是先执行方法体，然后将结果缓存起来
     * @param userId
     * @param userName
     * @return
     */
    UserInfo update(Integer userId, String userName);

    UserInfo get(Integer userId);

}
