package com.aismall.idea_sport;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.aismall.idea_sport.dao")
@SpringBootApplication
public class IdeaSportApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdeaSportApplication.class, args);
    }

}
