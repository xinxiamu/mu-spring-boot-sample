package com.example.shardingjdbc.service;



import com.example.shardingjdbc.entity.User;

import java.util.List;

public interface UserService {

    Integer addUser(User user);

    List<User> list();
}
