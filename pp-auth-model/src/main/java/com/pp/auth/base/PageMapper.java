package com.pp.auth.base;

import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.provider.ExampleProvider;

import java.util.List;

/**
 * @program: suntion-auth
 * @Description: 分页Mapper
 * @Author: Shen.Sun
 * @create: 2020-11-18 20:42
 **/
@tk.mybatis.mapper.annotation.RegisterMapper
public interface PageMapper<T> {

    /**
     * 根据Example条件进行查询
     *
     * @param example
     * @return
     */
    @SelectProvider(type = PageExampleProvider.class, method = "dynamicSQL")
    List<T> selectPageByExample(Object example);
}
