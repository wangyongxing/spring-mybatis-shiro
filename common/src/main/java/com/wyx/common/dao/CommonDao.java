package com.wyx.common.dao;

/**
 * Created with IntelliJ IDEA.
 * User: wangyongxing
 * Date: 16/9/1
 * Time: 上午10:38
 * To change this template use File | Settings | File Templates.
 */
public interface CommonDao<T> {
    /**
     * 保存
     *
     * @param entity
     * @return
     */
    public int save(T entity);

    /**
     * 根据id获取实体
     *
     * @param id
     * @return
     */
    T selectById(Long id);


    /**
     * 根据id 删除实体
     *
     * @param id
     * @return
     */
    int deleteById(Long id);


    /**
     *   根据条件删除实体
     *
     * @param entity
     * @return
     */
    int deleteByEntity(T entity);


    /**
     * 根据id单条更新数据
     *
     * @return
     */
    int update(T entity);
}
