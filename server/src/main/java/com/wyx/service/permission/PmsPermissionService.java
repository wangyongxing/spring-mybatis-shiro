package com.wyx.service.permission;


import com.wyx.common.page.Page;
import com.wyx.domain.permission.PmsPermission;

import java.util.List;

/* 权限service接口
*
* Created with IntelliJ IDEA.
* User: wangyongxing
* Date: 16/8/30
* Time: 下午2:39
* To change this template use File | Settings | File Templates.
*/
public interface PmsPermissionService {

    /**
     * 创建pmsPermission
     */
    void saveData(PmsPermission pmsPermission);

    /**
     * 修改pmsPermission
     */
    void updateData(PmsPermission pmsPermission);

    /**
     * 根据id获取数据pmsPermission
     *
     * @param id
     * @return
     */
    PmsPermission getDataById(Long id);

    /**
     * 分页查询pmsPermission
     *
     * @param page
     * @param pmsPermission
     * @return
     */
    List<PmsPermission> listPage(Page page, PmsPermission pmsPermission);

    /**
     * 检查权限名称是否已存在
     *
     * @param permissionName
     * @return
     */
    PmsPermission getByPermissionName(String permissionName);

    /**
     * 检查权限是否已存在
     *
     * @param permission
     * @return
     */
    PmsPermission getByPermission(String permission);

    /**
     * 检查权限名称是否已存在(其他id)
     *
     * @param permissionName
     * @param id
     * @return
     */
    PmsPermission getByPermissionNameNotEqId(String permissionName, Long id);

    /**
     * 删除
     *
     * @param permissionId
     */
    void delete(Long permissionId);

    /**
     * 根据角色查找角色对应的功能权限ID集
     *
     * @param roleId
     * @return
     */
    String getPermissionIdsByRoleId(Long roleId);

    /**
     * 查询所有的权限
     */
    List<PmsPermission> listAll();

}
