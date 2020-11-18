package com.pp.auth.base;

import com.github.pagehelper.PageInfo;

/**
 * 基类service类
 * @author scott
 * @date 2019/6/20 - 11:08
 * @param <T> 实体类对象
 */
public interface BaseService<T> extends BaseMapper<T> {
	PageInfo<T> getPage(Object var1, int page, int rows);
}
