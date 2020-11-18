package com.pp.auth.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

/**
 * @author scott
 * @date 2019/6/20 - 15:07
 */
public class BaseServiceImpl<D extends BaseMapper<T>, T> implements BaseService<T> {
    private final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

    @Autowired
    protected D dao;

    @Override
    public PageInfo<T> getPage(Object t, int pageNum, int pageSize) {
        this.logger.debug("queryPage start param: t = {}", t);
        List results = null;

        try {
            PageHelper.startPage(pageNum, pageSize);
            results = this.dao.selectByExample(t);
        } catch (Exception var7) {
            StringWriter sw = new StringWriter();
            var7.printStackTrace(new PrintWriter(sw));
            this.logger.error("Exception queryPage error: {}", sw);
        }

        this.logger.debug("queryPage end");
        return new PageInfo(results);
    }

    @Override
    @Transactional
    public int deleteByPrimaryKey(Object o) {
        return this.dao.deleteByPrimaryKey(o);
    }

    @Override
    @Transactional
    public int delete(T t) {
        return this.dao.delete(t);
    }

    @Override
    @Transactional
    public int insert(T t) {
        return this.dao.insert(t);
    }

    @Override
    @Transactional
    public int insertSelective(T t) {
        return this.dao.insertSelective(t);
    }

    @Override
    public boolean existsWithPrimaryKey(Object o) {
        return this.dao.existsWithPrimaryKey(o);
    }

    @Override
    public List<T> selectAll() {
        return this.dao.selectAll();
    }

    @Override
    public T selectByPrimaryKey(Object o) {
        return this.dao.selectByPrimaryKey(o);
    }

    @Override
    public int selectCount(T t) {
        return this.dao.selectCount(t);
    }

    @Override
    public List<T> select(T t) {
        return this.dao.select(t);
    }

    @Override
    public T selectOne(T t) {
        return this.dao.selectOne(t);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(T t) {
        return this.dao.updateByPrimaryKey(t);
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(T t) {
        return this.dao.updateByPrimaryKeySelective(t);
    }

    @Override
    @Transactional
    public int deleteByExample(Object o) {
        return this.dao.deleteByExample(o);
    }

    @Override
    public List<T> selectByExample(Object o) {
        return this.dao.selectByExample(o);
    }

    @Override
    public int selectCountByExample(Object o) {
        return this.dao.selectCountByExample(o);
    }

    @Override
    public T selectOneByExample(Object o) {
        return this.dao.selectOneByExample(o);
    }

    @Override
    @Transactional
    public int updateByExample(T t, Object o) {
        return this.dao.updateByExample(t, o);
    }

    @Override
    @Transactional
    public int updateByExampleSelective(T t, Object o) {
        return this.dao.updateByExampleSelective(t, o);
    }

    @Override
    public List<T> selectByExampleAndRowBounds(Object o, RowBounds rowBounds) {
        return this.dao.selectByExampleAndRowBounds(o,rowBounds);
    }

    @Override
    public List<T> selectByRowBounds(T t, RowBounds rowBounds) {
        return this.dao.selectByRowBounds(t, rowBounds);
    }

    @Override
    @Transactional
    public int insertList(List<? extends T> list) {
        return this.dao.insertList(list);
    }

    @Override
    @Transactional
    public int insertUseGeneratedKeys(T t) {
        return this.dao.insertUseGeneratedKeys(t);
    }
}
