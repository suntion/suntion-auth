package com.pp.auth.controller;

import com.github.pagehelper.PageHelper;
import com.pp.auth.base.BaseMapper;
import com.pp.auth.example.SysUserExample;
import com.pp.auth.model.SysUser;
import com.pp.auth.utils.VoResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


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

    @Resource
    BaseMapper<SysUser> userBaseMapper;

    @GetMapping("/testservice")
    public VoResult ser() {
        SysUserExample example = new SysUserExample();
        return VoResult.success(userBaseMapper.selectPageByExample(example));
    }


}
