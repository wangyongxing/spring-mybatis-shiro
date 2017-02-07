package com.wyx.dao.permission.impl;

import com.wyx.common.dao.impl.BaseDaoImpl;
import com.wyx.common.page.Page;
import com.wyx.dao.permission.PmsRolePermissionDao;
import com.wyx.domain.permission.PmsRolePermission;
import com.wyx.domain.permission.PmsRolePermissionConditions;
import com.wyx.mapper.permission.PmsRolePermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wangyongxing
 * Date: 16/9/1
 * Time: 下午5:26
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class PmsRolePermissionDaoImpl extends BaseDaoImpl<PmsRolePermission, PmsRolePermissionConditions> implements PmsRolePermissionDao {
    @Autowired
    PmsRolePermissionMapper mapper;

    @Override
    public void setMapper() {
        super.setMapper(mapper);
    }

    @Override
    public List<PmsRolePermission> listByRoleId(Long roleId) {
        PmsRolePermissionConditions conditions = new PmsRolePermissionConditions();
        conditions.createCriteria().andRoleIdEqualTo(roleId);
        return mapper.selectByExample(conditions);
    }

    @Override
    public void deleteByRoleId(Long roleId) {
        PmsRolePermissionConditions conditions = new PmsRolePermissionConditions();
        conditions.createCriteria().andRoleIdEqualTo(roleId);
        mapper.deleteByExample(conditions);
    }

    @Override
    public List listPage(Page page, Map<String, Object> map) {
        PmsRolePermissionConditions conditions = new PmsRolePermissionConditions();
        conditions.createCriteria().addByMap(map);
        if(page!=null){
            page.setTotalNum(mapper.countByExample(conditions));
            conditions.setPage(page);
        }
        return mapper.selectByExample(conditions);
    }

    @Override
    public List<PmsRolePermission> listByRoleIds(List<Long> rolesId){
    PmsRolePermissionConditions conditions = new PmsRolePermissionConditions();
        conditions.createCriteria().andRoleIdIn(rolesId);
        return mapper.selectByExample(conditions);
    }
}
