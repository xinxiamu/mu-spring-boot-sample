package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching //开启缓存
@SpringBootApplication
public class SpringRedisCacheApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringRedisCacheApp.class, args);
    }
}
