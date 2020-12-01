package com.pp.test.controller;

import com.pp.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: suntion-auth
 * @Description: 测试接口
 * @Author: Shen.Sun  suntion@yeah.net
 * @create: 2020-12-01 18:08
 **/
@Controller
@RequestMapping
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/pp/test")
    @ResponseBody
    public String test() {
        return testService.test();
    }

}
