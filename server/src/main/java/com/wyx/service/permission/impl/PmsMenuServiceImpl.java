
package com.wyx.service.permission.impl;

import com.wyx.dao.permission.PmsMenuDao;
import com.wyx.dao.permission.PmsMenuRoleDao;
import com.wyx.domain.permission.PmsMenu;
import com.wyx.domain.permission.PmsMenuRole;
import com.wyx.service.permission.PmsMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 菜单service接口实现
 * Created with IntelliJ IDEA.
 * User: wangyongxing
 * Date: 16/8/30
 * Time: 下午2:39
 * To change this template use File | Settings | File Templates.
 */
@Service("pmsMenuService")
public class PmsMenuServiceImpl implements PmsMenuService {

    @Autowired
    private PmsMenuDao pmsMenuDao;
    @Autowired
    private PmsMenuRoleDao pmsMenuRoleDao;

    /**
     * 保存菜单PmsMenu
     *
     * @param menu
     */
    public void savaMenu(PmsMenu menu) {
        pmsMenuDao.save(menu);
    }

    /**
     * 根据父菜单ID获取该菜单下的所有子孙菜单.<br/>
     *
     * @param parentId (如果为空，则为获取所有的菜单).<br/>
     * @return menuList.
     */
    @SuppressWarnings("rawtypes")
    public List getListByParent(Long parentId) {

        return pmsMenuDao.getListByParent(parentId);
    }

    /**
     * 根据id删除菜单
     */
    public void delete(Long id) {
        pmsMenuDao.deleteById(id);
    }

    /**
     * 根据角色id串获取菜单
     *
     * @param roleIdsStr
     * @return
     */
    @SuppressWarnings("rawtypes")
    public List listByRoleIds(String roleIdsStr) {
        List<String> roldIds = Arrays.asList(roleIdsStr.split(","));

        return pmsMenuDao.selectByRoleIds(roldIds);
    }

    /**
     * 根据菜单ID查找菜单（可用于判断菜单下是否还有子菜单）.
     *
     * @param parentId .
     * @return menuList.
     */
    public List<PmsMenu> listByParentId(Long parentId) {

        return pmsMenuDao.listByParentId(parentId);
    }

    /**
     * 根据名称和是否叶子节点查询数据
     *
     * @param map
     * @return
     */
    public List<PmsMenu> getMenuByNameAndIsLeaf(Map<String, Object> map) {

        return pmsMenuDao.getMenuByNameAndIsLeaf(map);
    }

    /**
     * 根据菜单ID获取菜单.
     *
     * @param pid
     * @return
     */
    public PmsMenu getById(Long pid) {
        return pmsMenuDao.selectById(pid);
    }

    /**
     * 更新菜单.
     *
     * @param menu
     */
    public void update(PmsMenu menu) {
        pmsMenuDao.update(menu);

    }

    /**
     * 根据角色查找角色对应的菜单ID集
     *
     * @param roleId
     * @return
     */
    public String getMenuIdsByRoleId(Long roleId) {
        List<PmsMenuRole> menuList = pmsMenuRoleDao.listByRoleId(roleId);
        StringBuffer menuIds = new StringBuffer("");
        if (menuList != null && !menuList.isEmpty()) {
            for (PmsMenuRole rm : menuList) {
                menuIds.append(rm.getMenuId()).append(",");
            }
        }
        return menuIds.toString();

    }
}
