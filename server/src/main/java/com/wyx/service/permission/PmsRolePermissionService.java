package com.wyx.service.permission;

import com.wyx.common.page.Page;
import com.wyx.domain.permission.PmsRolePermission;

import java.util.List;
import java.util.Set;

/*
 * 角色权限service接口
 *
 * Created with IntelliJ IDEA.
 * User: wangyongxing
 * Date: 16/8/30
 * Time: 下午2:39
 * To change this template use File | Settings | File Templates.
 */
public interface PmsRolePermissionService {

    /**
     * 根据操作员ID，获取所有的功能权限集
     *
     * @param operatorId
     */
    public Set<String> getPermissionsByOperatorId(Long operatorId);

    /**
     * 创建pmsRolePermission
     */
    void saveData(PmsRolePermission pmsRolePermission);

    /**
     * 修改pmsRolePermission
     */
    void updateData(PmsRolePermission pmsRolePermission);

    /**
     * 根据id获取数据pmsRolePermission
     *
     * @param id
     * @return
     */
    PmsRolePermission getDataById(Long id);

    /**
     * 分页查询pmsRolePermission
     *
     * @param page
     * @param pmsRolePermission
     * @return
     */
    List<PmsRolePermission> listPage(Page page, PmsRolePermission pmsRolePermission);

    /**
     * 保存角色和权限之间的关联关系
     */
    void saveRolePermission(Long roleId, String rolePermissionStr);

}
