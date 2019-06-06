package com.springboot.luckymoney;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springboot.luckymoney.mapper")
public class LuckymoneyApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuckymoneyApplication.class, args);
    }

}
