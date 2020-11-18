package com.pp.auth.config;

import com.pp.auth.base.BaseService;
import com.pp.auth.base.BaseServiceImpl;
import com.pp.auth.dao.*;
import com.pp.auth.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: suntion-auth
 * @Description: Service自动注入
 * @Author: Shen.Sun
 * @create: 2020-11-18 17:58
 **/
@Configuration
public class ServiceConfiguration {
    public ServiceConfiguration() {
        System.out.println("ServiceConfiguration容器启动初始化。。。");
    }

    @Bean("configBaseService")
    public BaseService<SysConfig> configBaseService() {
        return new BaseServiceImpl<SysConfigMapper, SysConfig>();
    }

    @Bean("deptBaseService")
    public BaseService<SysDept> deptBaseService() {
        return new BaseServiceImpl<SysDeptMapper, SysDept>();
    }

    @Bean("dictDataBaseService")
    public BaseService<SysDictData> dictDataBaseService() {
        return new BaseServiceImpl<SysDictDataMapper, SysDictData>();
    }

    @Bean("dictTypeBaseService")
    public BaseService<SysDictType> dictTypeBaseService() {
        return new BaseServiceImpl<SysDictTypeMapper, SysDictType>();
    }

    @Bean("postBaseService")
    public BaseService<SysPost> postBaseService() {
        return new BaseServiceImpl<SysPostMapper, SysPost>();
    }

    @Bean("resourceBaseService")
    public BaseService<SysResource> resourceBaseService() {
        return new BaseServiceImpl<SysResourceMapper, SysResource>();
    }

    @Bean("roleBaseService")
    public BaseService<SysRole> roleBaseService() {
        return new BaseServiceImpl<SysRoleMapper, SysRole>();
    }

    @Bean("roleResourceBaseService")
    public BaseService<SysRoleResource> roleResourceBaseService() {
        return new BaseServiceImpl<SysRoleResourceMapper, SysRoleResource>();
    }

    @Bean("userBaseService")
    public BaseService<SysUser> userBaseService() {
        return new BaseServiceImpl<SysUserMapper, SysUser>();
    }

    @Bean("userDeptBaseService")
    public BaseService<SysUserDept> userDeptBaseService() {
        return new BaseServiceImpl<SysUserDeptMapper, SysUserDept>();
    }

    @Bean("userPostBaseService")
    public BaseService<SysUserPost> userPostBaseService() {
        return new BaseServiceImpl<SysUserPostMapper, SysUserPost>();
    }

    @Bean("userRoleBaseService")
    public BaseService<SysUserRole> userRoleBaseService() {
        return new BaseServiceImpl<SysUserRoleMapper, SysUserRole>();
    }


}
