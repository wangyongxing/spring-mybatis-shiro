package com.wyx.service.permission;

import com.wyx.common.page.Page;
import com.wyx.domain.permission.PmsRole;

import java.util.List;

/*
 * 角色service接口
 *
 * Created with IntelliJ IDEA.
 * User: wangyongxing
 * Date: 16/8/30
 * Time: 下午2:39
 * To change this template use File | Settings | File Templates.
 */
public interface PmsRoleService {

    /**
     * 创建pmsRole
     */
    void saveData(PmsRole pmsRole);

    /**
     * 修改pmsRole
     */
    void updateData(PmsRole pmsRole);

    /**
     * 根据id获取数据pmsRole
     *
     * @param id
     * @return
     */
    PmsRole getDataById(Long id);

    /**
     * 分页查询pmsRole
     *
     * @param page
     * @param pmsRole
     * @return
     */
    List<PmsRole> listPage(Page page, PmsRole pmsRole);

    /**
     * 获取所有角色列表，以供添加操作员时选择.
     *
     * @return roleList .
     */
    public List<PmsRole> listAllRole();

    /**
     * 判断此权限是否关联有角色
     *
     * @param permissionId
     * @return
     */
    List<PmsRole> listByPermissionId(Long permissionId);

    /**
     * 根据角色名或者角色编号查询角色
     *
     * @param roleName
     * @param roleCode
     * @return
     */
    PmsRole getByRoleNameOrRoleCode(String roleName, String roleCode);

    /**
     * 删除
     *
     * @param roleId
     */
    void delete(Long roleId);

}
