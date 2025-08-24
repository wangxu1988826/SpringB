package com.wangxu.learnsboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wangxu.learnsboot.mapper")
public class LearnsbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnsbootApplication.class, args);
    }

}
