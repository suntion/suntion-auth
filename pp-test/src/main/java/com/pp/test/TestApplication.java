package com.pp.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @program: suntion-auth
 * @Description:
 * @Author: Shen.Sun
 * @create: 2020-11-26 17:46
 **/
@SpringBootApplication
@ComponentScan(basePackages={"com.pp"})
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

}
