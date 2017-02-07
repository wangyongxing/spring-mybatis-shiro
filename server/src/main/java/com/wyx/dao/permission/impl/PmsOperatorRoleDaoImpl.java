package com.wyx.dao.permission.impl;

import com.wyx.common.dao.impl.BaseDaoImpl;
import com.wyx.dao.permission.PmsOperatorRoleDao;
import com.wyx.domain.permission.PmsOperator;
import com.wyx.domain.permission.PmsOperatorRole;
import com.wyx.domain.permission.PmsOperatorRoleConditions;
import com.wyx.mapper.permission.PmsOperatorRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wangyongxing
 * Date: 16/9/1
 * Time: 下午2:43
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class PmsOperatorRoleDaoImpl extends BaseDaoImpl<PmsOperatorRole, PmsOperatorRoleConditions> implements PmsOperatorRoleDao {

    @Autowired
    private PmsOperatorRoleMapper mapper;

    @Override
    @Autowired
    public void setMapper() {
        super.setMapper(mapper);

    }

    @Override
    public List<PmsOperatorRole> listByOperatorId(Long operatorId) {
        PmsOperatorRoleConditions conditions = new PmsOperatorRoleConditions();
        conditions.createCriteria().andOperatorIdEqualTo(operatorId);
        return selectByExample(conditions);
    }

    @Override
    public void deleteByRoleIdAndOperatorId(Long roleId, Long operatorId) {
        PmsOperatorRoleConditions conditions = new PmsOperatorRoleConditions();
        conditions.createCriteria().andOperatorIdEqualTo(operatorId).andRoleIdEqualTo(roleId);
        deleteByExample(conditions);
    }

    @Override
    public List<PmsOperatorRole> listByRoleId(long roleId) {
        PmsOperatorRoleConditions conditions = new PmsOperatorRoleConditions();
        conditions.createCriteria().andRoleIdEqualTo(roleId);
        return selectByExample(conditions);
    }
}
