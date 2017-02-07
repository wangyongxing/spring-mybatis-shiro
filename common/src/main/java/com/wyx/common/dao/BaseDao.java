package com.wyx.common.dao;

import java.util.List;

/**
 * 数据访问层基础支撑接口.
 */
public interface BaseDao<BaseDomain,T> {



    void setMapper();

    /**保存
     * @param record
     * @return
     */
    int save(BaseDomain record);

    /**
     * 根据id获取实体
     * @param id
     * @return
     */
    BaseDomain selectById(Long id);

    /**
     * 根据id 删除实体
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     *   根据条件删除实体
     * @param example
     * @return
     */
    int deleteByExample(T example);


    /**
     * 更新
     * @return
     */
    int update(BaseDomain entity);

    /**
     * 根据条件获取实体集合
     * @param example
     * @return
     */
    List<BaseDomain> selectByExample(T example);

    /**
     * 根据条件更新
     * @param entity
     *  更新数据
     * @param example
     * 更新条件
     * @return
     */
    int updateByExampleSelective(BaseDomain entity, T example);

    /**
     * 根据条件 获取总行数
     * @param example
     * @return
     */
    int countByExample(T example);

}
