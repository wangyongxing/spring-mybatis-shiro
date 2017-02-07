package com.wyx.dao.permission;

import com.wyx.common.dao.BaseDao;
import com.wyx.domain.permission.PmsOperatorRole;
import com.wyx.domain.permission.PmsOperatorRoleConditions;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wangyongxing
 * Date: 16/9/1
 * Time: 下午2:43
 * To change this template use File | Settings | File Templates.
 */
public interface PmsOperatorRoleDao extends BaseDao<PmsOperatorRole,PmsOperatorRoleConditions> {

    /**
     * 根据操作员ID查找该操作员关联的角色.
     *
     * @param operatorId
     *            .
     * @return list .
     */
    List<PmsOperatorRole> listByOperatorId(Long operatorId);


    void deleteByRoleIdAndOperatorId(Long roleId, Long operatorId);


    List<PmsOperatorRole> listByRoleId(long roleId);
}
