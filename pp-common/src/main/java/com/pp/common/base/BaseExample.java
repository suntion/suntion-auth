package com.pp.common.base;

/**
 * @program: suntion-auth
 * @Description: 基础查询类
 * @Author: Shen.Sun
 * @create: 2020-11-24 15:17
 **/
public class BaseExample {

    protected int pageSize = 15;

    protected int pageNum = 0;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
