package com.wyx.dao.permission;

import com.wyx.common.dao.BaseDao;
import com.wyx.common.page.Page;
import com.wyx.domain.permission.PmsRolePermission;
import com.wyx.domain.permission.PmsRolePermissionConditions;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wangyongxing
 * Date: 16/9/1
 * Time: 下午4:12
 * To change this template use File | Settings | File Templates.
 */
public interface PmsRolePermissionDao extends BaseDao<PmsRolePermission, PmsRolePermissionConditions> {

    List<PmsRolePermission> listByRoleId(Long roleId);

    void deleteByRoleId(Long roleId);

    public List listPage(Page page, Map<String, Object> map);

    List<PmsRolePermission> listByRoleIds(List<Long> rolesId);
}
