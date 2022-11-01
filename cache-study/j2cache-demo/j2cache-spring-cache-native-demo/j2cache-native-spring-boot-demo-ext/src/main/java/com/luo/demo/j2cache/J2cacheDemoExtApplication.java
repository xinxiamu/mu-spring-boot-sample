package com.luo.demo.j2cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * J2cache SpringBoot L1 Caffeine L2 Redis缓存示例
 *
 * @author luohq
 * @date 2022-04-03 11:57
 */
@SpringBootApplication
public class J2cacheDemoExtApplication {

    public static void main(String[] args) {
        SpringApplication.run(J2cacheDemoExtApplication.class, args);
    }

}
