package com.wyx.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: wangyongxing
 * Date: 16/8/30
 * Time: 下午2:39
 * To change this template use File | Settings | File Templates.
 */
public class BaseDomain {

    private Long id;
    private Date createTime = new Date();// 创建时间.
    private Date editTime = new Date();// 修改时间.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }
}
