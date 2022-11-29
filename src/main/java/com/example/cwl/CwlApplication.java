package com.example.cwl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//@SpringBootApplication(scanBasePackages = "com.Controller")
@SpringBootApplication(scanBasePackages = {"com.Controller","com.Service","com.interceptor"})
@MapperScan("com.Mapper")
//@ComponentScan(basePackages = "com.Service")
public class CwlApplication {

    public static void main(String[] args) {
        SpringApplication.run(CwlApplication.class, args);
    }

}
