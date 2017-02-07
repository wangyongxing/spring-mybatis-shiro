package com.wyx.dao.permission;

import com.wyx.common.dao.BaseDao;
import com.wyx.common.page.Page;
import com.wyx.domain.permission.PmsRole;
import com.wyx.domain.permission.PmsRoleConditions;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wangyongxing
 * Date: 16/9/1
 * Time: 下午4:18
 * To change this template use File | Settings | File Templates.
 */
public interface PmsRoleDao extends BaseDao<PmsRole, PmsRoleConditions> {

    List<PmsRole> listPage(Page page, Map<String, Object> paramMap);

    List<PmsRole> listByPermissionId(Long permissionId);

    public PmsRole getByRoleNameOrRoleCode(String roleName, String roleCode);
}
