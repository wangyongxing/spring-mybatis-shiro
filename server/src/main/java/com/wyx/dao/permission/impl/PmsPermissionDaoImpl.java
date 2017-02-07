package com.wyx.dao.permission.impl;

import com.wyx.common.dao.impl.BaseDaoImpl;
import com.wyx.common.page.Page;
import com.wyx.common.utils.CollectionUtils;
import com.wyx.dao.permission.PmsPermissionDao;
import com.wyx.domain.permission.PmsPermission;
import com.wyx.domain.permission.PmsPermissionConditions;
import com.wyx.mapper.permission.PmsPermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wangyongxing
 * Date: 16/9/1
 * Time: 下午5:22
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class PmsPermissionDaoImpl extends BaseDaoImpl<PmsPermission, PmsPermissionConditions> implements PmsPermissionDao {
    @Autowired
    PmsPermissionMapper mapper;

    @Override
    public List<PmsPermission> listPage(Page page, Map<String, Object> map) {
        PmsPermissionConditions conditions = new PmsPermissionConditions();
        conditions.createCriteria().addByMap(map);
        if (page != null) {
            page.setTotalNum(mapper.countByExample(conditions));
            conditions.setPage(page);
        }
        return mapper.selectByExample(conditions);
    }

    @Override
    public PmsPermission getByPermissionNameNotEqId(String permissionName, Long id) {
        return null;
    }

    @Override
    public List<PmsPermission> findByIds(List<Long> ids) {
        PmsPermissionConditions conditions = new PmsPermissionConditions();
        conditions.createCriteria().andIdIn(ids);

        return mapper.selectByExample(conditions);

    }

    @Override
    public PmsPermission getByPermissionName(String permissionName) {
        PmsPermissionConditions conditions = new PmsPermissionConditions();
        conditions.createCriteria().andPermissionNameEqualTo(permissionName);
        List<PmsPermission> list = mapper.selectByExample(conditions);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    @Override
    @Autowired
    public void setMapper() {
        super.setMapper(mapper);
    }
}
