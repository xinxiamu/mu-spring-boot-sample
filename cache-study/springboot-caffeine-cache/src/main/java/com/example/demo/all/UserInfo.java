package com.example.demo.all;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private static final long serialVersionUID = 32231210625957348L;

    public Integer id;
    public String Name;
    public Integer age;

    public UserInfo(Integer id, String name, Integer age) {
        this.id = id;
        Name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
