package com.example.demo.all;

public interface AllService {

    Integer save(Integer userId, String userName, Integer age);
    Boolean update(Integer userId, String userName);
    String get(Integer userId);
}
