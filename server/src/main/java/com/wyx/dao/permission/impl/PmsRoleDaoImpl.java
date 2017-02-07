package com.wyx.dao.permission.impl;

import com.wyx.common.dao.impl.BaseDaoImpl;
import com.wyx.common.page.Page;
import com.wyx.common.utils.StringUtil;
import com.wyx.dao.permission.PmsRoleDao;
import com.wyx.domain.permission.PmsRole;
import com.wyx.domain.permission.PmsRoleConditions;
import com.wyx.mapper.permission.PmsRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wangyongxing
 * Date: 16/9/1
 * Time: 下午5:12
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class PmsRoleDaoImpl extends BaseDaoImpl<PmsRole, PmsRoleConditions> implements PmsRoleDao {
    @Autowired
    private PmsRoleMapper mapper;

    @Override
    @Autowired
    public void setMapper() {
        super.setMapper(mapper);
    }

    @Override
    public List<PmsRole> listPage(Page page, Map<String, Object> paramMap) {
        PmsRoleConditions conditions = new PmsRoleConditions();
        conditions.createCriteria().addByMap(paramMap);
        if (page != null) {
            page.setTotalNum(mapper.countByExample(conditions));
            conditions.setPage(page);
        }
        return mapper.selectByExample(conditions);
    }

    @Override
    public List<PmsRole> listByPermissionId(Long permissionId) {
        return mapper.listByPermissionId(permissionId);
    }

    @Override
    public PmsRole getByRoleNameOrRoleCode(String roleName, String roleCode) {
        PmsRoleConditions conditions = new PmsRoleConditions();
        conditions.createCriteria().andRoleNameEqualTo(roleName).andRoleCodeEqualTo(roleCode);
        List<PmsRole> list = mapper.selectByExample(conditions);
        if (StringUtil.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }
}
