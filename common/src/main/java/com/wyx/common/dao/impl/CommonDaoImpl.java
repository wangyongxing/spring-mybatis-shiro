package com.wyx.common.dao.impl;

import com.wyx.common.dao.CommonDao;
import com.wyx.common.domain.BaseDomain;
import com.wyx.common.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: wangyongxing
 * Date: 16/9/1
 * Time: 上午10:43
 * To change this template use File | Settings | File Templates.
 */
public abstract class CommonDaoImpl<T extends BaseDomain> implements CommonDao<T> {
    @Autowired
    private Mapper mapper;
    @Override
    public int save(T entity) {
        return mapper.insert(entity);
    }

    @Override
    public T selectById(Long id) {
        return (T) mapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByEntity(T entity) {
        return mapper.delete(entity);
    }

    @Override
    public int update(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }
}
