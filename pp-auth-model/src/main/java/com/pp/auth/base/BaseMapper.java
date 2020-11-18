package com.pp.auth.base;

import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author scott
 * @date 2019/6/19 - 21:17
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T>, ExampleMapper<T> {
}
