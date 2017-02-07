package com.wyx.dao.permission;

import com.wyx.common.dao.BaseDao;
import com.wyx.domain.permission.PmsMenuRole;
import com.wyx.domain.permission.PmsMenuRoleConditions;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wangyongxing
 * Date: 16/9/1
 * Time: 下午3:10
 * To change this template use File | Settings | File Templates.
 */
public interface PmsMenuRoleDao extends BaseDao<PmsMenuRole, PmsMenuRoleConditions> {

    /**
     * 根据角色ID统计关联到此角色的菜单数.
     *
     * @param roleId 角色ID.
     * @return count.
     */
    List<PmsMenuRole> listByRoleId(Long roleId);

    int countMenuByRoleId(Long roleId);

    public void deleteByRoleId(Long roleId);
}
