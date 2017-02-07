package com.wyx.dao.permission;

import com.wyx.common.dao.BaseDao;
import com.wyx.common.page.Page;
import com.wyx.domain.permission.PmsPermission;
import com.wyx.domain.permission.PmsPermissionConditions;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wangyongxing
 * Date: 16/9/1
 * Time: 下午3:19
 * To change this template use File | Settings | File Templates.
 */
public interface PmsPermissionDao extends BaseDao<PmsPermission,PmsPermissionConditions> {

    List<PmsPermission> listPage(Page page, Map<String,Object> map);

    PmsPermission getByPermissionNameNotEqId(String permissionName, Long id);


    List<PmsPermission> findByIds(List<Long> ids);

    PmsPermission getByPermissionName(String permissionName);
}
