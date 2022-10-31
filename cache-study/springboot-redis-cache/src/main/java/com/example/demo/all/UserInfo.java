package com.example.demo.all;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private static final long serialVersionUID = 32231210625957348L;

    public Integer id;
    public String name;
    public Integer age;

    public UserInfo() {
    }

    public UserInfo(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
