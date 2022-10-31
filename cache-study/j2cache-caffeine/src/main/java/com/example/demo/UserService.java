package com.example.demo;

import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.CacheObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    // 模拟数据库
    List<User> userList = new ArrayList<>();

    @Autowired
    private CacheChannel cacheChannel;

    public void add (User user) {
        System.out.println(">>>>新增用户");
        // 插入数据库
        userList.add(user);
        // 设置缓存。region理解：https://my.oschina.net/javayou/blog/3031773
        cacheChannel.set("user", user.getName(), user);
    }

    public User get(String name){
        System.out.println(">>>>>开始查询缓存：");
        CacheObject user = cacheChannel.get("user", name);
        System.out.println(">>>>>level:" + user.getLevel());
        System.out.println(">>>>>region:" + user.getRegion());
        System.out.println(">>>>>key:" + user.getKey());
        System.out.println(">>>>>value:" + user.getValue());

        Object value = user.getValue();
        if (value == null) {
            System.out.println(">>>>缓存为空，从数据库获取");
            value = userList.get(0);

            //缓存
            if (value != null) {
                cacheChannel.set("user", userList.get(0).getName(), value);
            }
        }

        return (User) value;
    }

    //缓存更新
    public void update(String name){
        User u = userList.stream().filter(user -> user.getName().equals(name)).findFirst().orElse(null);
        u.setAge(30);

        //更新缓存
        cacheChannel.set("user", name, u);
    }

    public void evict(String name){
        //清除缓存
        cacheChannel.evict("user", name);
    }
}
