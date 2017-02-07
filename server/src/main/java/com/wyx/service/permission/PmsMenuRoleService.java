
package com.wyx.service.permission;

/*
 * 菜单角色service接口
 * Created with IntelliJ IDEA.
 * User: wangyongxing
 * Date: 16/8/30
 * Time: 下午2:39
 * To change this template use File | Settings | File Templates.
 */
public interface PmsMenuRoleService {

    /**
     * 根据角色ID统计关联到此角色的菜单数.
     *
     * @param roleId 角色ID.
     * @return count.
     */
    public int countMenuByRoleId(Long roleId);

    /**
     * 根据角色id，删除该角色关联的所有菜单权限
     *
     * @param roleId
     */
    public void deleteByRoleId(Long roleId);

    public void saveRoleMenu(Long roleId, String roleMenuStr);

}
