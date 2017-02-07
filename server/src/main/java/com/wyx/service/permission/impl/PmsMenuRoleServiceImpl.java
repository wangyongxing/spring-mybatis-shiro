package com.wyx.service.permission.impl;

import com.alibaba.druid.util.StringUtils;
import com.wyx.dao.permission.PmsMenuRoleDao;
import com.wyx.domain.permission.PmsMenuRole;
import com.wyx.service.permission.PmsMenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 * 菜单角色service接口实现
 * Created with IntelliJ IDEA.
 * User: wangyongxing
 * Date: 16/8/30
 * Time: 下午2:39
 */
@Service("pmsMenuRoleService")
public class PmsMenuRoleServiceImpl implements PmsMenuRoleService {

    @Autowired
    private PmsMenuRoleDao pmsMenuRoleDao;

    /**
     * 根据角色ID统计关联到此角色的菜单数.
     *
     * @param roleId 角色ID.
     * @return count.
     */
    public int countMenuByRoleId(Long roleId) {
        return pmsMenuRoleDao.countMenuByRoleId(roleId);

    }

    /**
     * 根据角色id，删除该角色关联的所有菜单权限
     *
     * @param roleId
     */
    public void deleteByRoleId(Long roleId) {

        pmsMenuRoleDao.deleteByRoleId(roleId);
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveRoleMenu(Long roleId, String roleMenuStr) {
        // 删除原来的角色与权限关联
        pmsMenuRoleDao.deleteByRoleId(roleId);
        if (!StringUtils.isEmpty(roleMenuStr)) {
            // 创建新的关联
            String[] menuIds = roleMenuStr.split(",");
            for (int i = 0; i < menuIds.length; i++) {
                Long menuId = Long.valueOf(menuIds[i]);
                PmsMenuRole item = new PmsMenuRole();
                item.setMenuId(menuId);
                item.setRoleId(roleId);
                pmsMenuRoleDao.save(item);
            }
        }
    }
}
