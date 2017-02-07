package com.wyx.dao.permission.impl;

import com.wyx.common.dao.impl.BaseDaoImpl;
import com.wyx.dao.permission.PmsMenuRoleDao;
import com.wyx.domain.permission.PmsMenuRole;
import com.wyx.domain.permission.PmsMenuRoleConditions;
import com.wyx.mapper.permission.PmsMenuRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wangyongxing
 * Date: 16/9/1
 * Time: 下午3:11
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class PmsMenuRoleDaoImpl extends BaseDaoImpl<PmsMenuRole, PmsMenuRoleConditions> implements PmsMenuRoleDao {
    @Autowired
    PmsMenuRoleMapper mapper;

    @Override
    public void setMapper() {
        super.setMapper(mapper);
    }

    @Override
    public List<PmsMenuRole> listByRoleId(Long roleId) {
        PmsMenuRoleConditions conditions = new PmsMenuRoleConditions();
        conditions.createCriteria().andRoleIdEqualTo(roleId);
        return mapper.selectByExample(conditions);
    }

    @Override
    public int countMenuByRoleId(Long roleId) {
        PmsMenuRoleConditions conditions = new PmsMenuRoleConditions();
        conditions.createCriteria().andRoleIdEqualTo(roleId);
        return mapper.countByExample(conditions);
    }

    @Override
    public void deleteByRoleId(Long roleId) {
        PmsMenuRoleConditions conditions = new PmsMenuRoleConditions();
        conditions.createCriteria().andRoleIdEqualTo(roleId);
        mapper.deleteByExample(conditions);
    }
}
