package com.wyx.common.dao.impl;

import com.wyx.common.dao.BaseDao;
import com.wyx.common.exception.BizException;
import com.wyx.common.mapper.Mapper;

import java.util.List;

/**
 * 数据访问层基础支撑接口实现
 * Created with IntelliJ IDEA.
 * User: wangyongxing
 * Date: 16/8/31
 * Time: 下午4:56
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseDaoImpl<BaseDomain, T> implements BaseDao<BaseDomain, T> {

    private Mapper mapper;

    public void setMapper(Mapper<BaseDomain> mapper) {
        this.mapper = mapper;
    }


    @Override
    public int save(BaseDomain record) {
        int result = mapper.insertSelective(record);
        return result;
    }

    @Override
    public BaseDomain selectById(Long id) {

        return (BaseDomain) mapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(Long id) {

        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByExample(T example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int update(BaseDomain entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<BaseDomain> selectByExample(T example) {

        return mapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(BaseDomain entity, T example) {
        return mapper.updateByExampleSelective(entity, example);
    }

    @Override
    public int countByExample(T example) {
        return mapper.countByExample(example);
    }
}
