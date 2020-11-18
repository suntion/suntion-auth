package com.pp.auth.controller;

import com.pp.auth.base.BaseService;
import com.pp.auth.model.SysUser;
import com.pp.auth.utils.VoResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/pp/auth/v1")
public class TestController {

    @Autowired
    ApplicationContext applicationContext;

    @GetMapping("/testapi")
    public VoResult axbBind(){
        String[] str = applicationContext.getBeanDefinitionNames();
        for (String string : str) {
            System.out.println("..."+string);
        }
        return VoResult.success();
    }

    @Autowired
    BaseService<SysUser> userBaseService;

    @GetMapping("/testservice")
    public VoResult ser() {
        return VoResult.success(userBaseService.selectAll());
    }

}
