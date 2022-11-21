package com.example.shardingjdbc.repository;


import com.example.shardingjdbc.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository {

    Integer addUser(User user);

    List<User> list();

}

