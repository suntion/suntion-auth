package com.pp.test.service;

import org.springframework.stereotype.Service;

/**
 * @program: suntion-auth
 * @Description: 测试类
 * @Author: Shen.Sun  suntion@yeah.net
 * @create: 2020-12-01 18:09
 **/
@Service
public class TestService {

    public String test() {
        int a = 1;
        int b = 0;
        int c = a/b;
        return "123";
    }
}
