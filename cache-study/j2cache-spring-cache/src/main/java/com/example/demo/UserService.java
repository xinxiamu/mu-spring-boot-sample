package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.CacheObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Service
@CacheConfig(cacheNames = UserService.CACHE_NAME)
public class UserService {

    protected static final String CACHE_NAME = "userInfo"; //缓存名称

    // 模拟数据库
    List<User> userList = new ArrayList<>();

    @Resource
    private CacheChannel cacheChannel;

    @Resource
    private CacheManager cacheManager;

    public void add (User user) {
        log.info("新增用户：{}", user.getName());
        if (getUserById(user.getId()) != null) {
            throw new NullPointerException("该id用户已经存在");
        }
        // 插入数据库
        userList.add(user);
    }

    @Cacheable(key = "#id")
    public User get(Long id){
        System.out.println(">>>>>获取用户信息：");

        User user1 = getUserById(id);
        if (user1 == null) {
            throw new NullPointerException("用户不存在");
        }
        if (user1 != null) {
            log.info("从数据库获取到用户：{}", user1.getName());
        }

        return user1;
    }

    //缓存更新
    @CachePut(key = "#user.id")
    public User update(User user){
        log.info("》》》》更新用户信息：id={};name={};age={}", user.getId(), user.getName(), user.getAge());
        User u = getUserById(user.getId());
        if (u == null) throw new NullPointerException("用户不存在");
        u.setAge(user.getAge());
        u.setName(user.getName());
        return user;
    }

    @CacheEvict(key = "#id")
    public boolean del(Long id){
        log.info(">>>>>>从数据库删除用户：{}", id);
        User user = getUserById(id);
        if (user == null) throw new NullPointerException("用户不存在");
        userList.remove(user);
        return true;
    }

    //删除所有缓存
    @CacheEvict(allEntries = true)
    public Integer deleteAll() {
        Collection<String> keys = this.cacheChannel.keys(CACHE_NAME);
        log.info("[CLEAR] deleteAllMyObj keys: {}", keys);
        return keys.size();
    }

    private User getUserById(Long id) {
        if (userList == null || userList.isEmpty()) {
            return null;
        }
        return userList.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }
}
