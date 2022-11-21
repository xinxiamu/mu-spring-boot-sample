package com.example.shardingjdbc.service.impl;


import com.example.shardingjdbc.entity.User;
import com.example.shardingjdbc.repository.UserRepository;
import com.example.shardingjdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Integer addUser(User user) {

        // 强制路由主库
        //HintManager.getInstance().setMasterRouteOnly();
        return userRepository.addUser(user);
    }

    @Override
    public List<User> list() {

        return userRepository.list();
    }
}
