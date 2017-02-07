
package com.wyx.service.permission.impl;

import com.wyx.common.page.Page;
import com.wyx.dao.permission.PmsRoleDao;
import com.wyx.domain.permission.PmsRole;
import com.wyx.service.permission.PmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色service接口实现
 */
@Service("pmsRoleService")
public class PmsRoleServiceImpl implements PmsRoleService {
    @Autowired
    private PmsRoleDao pmsRoleDao;

    /**
     * 创建pmsOperator
     */
    public void saveData(PmsRole pmsRole) {
        pmsRoleDao.save(pmsRole);
    }

    /**
     * 修改pmsOperator
     */
    public void updateData(PmsRole pmsRole) {
        pmsRoleDao.update(pmsRole);
    }

    /**
     * 根据id获取数据pmsOperator
     *
     * @param id
     * @return
     */
    public PmsRole getDataById(Long id) {
        return pmsRoleDao.selectById(id);

    }

    /**
     * 分页查询pmsOperator
     *
     * @param page
     * @param pmsRole
     * @return
     */
    public List<PmsRole> listPage(Page page, PmsRole pmsRole) {
        Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
        //paramMap.put("roleName", pmsRole.getRoleName()); // 角色名称（模糊查询）
        return pmsRoleDao.listPage(page, paramMap);
    }

    /**
     * 获取所有角色列表，以供添加操作员时选择.
     *
     * @return roleList .
     */
    public List<PmsRole> listAllRole() {
        return pmsRoleDao.listPage(null, null);
    }

    /**
     * 判断此权限是否关联有角色
     *
     * @param permissionId
     * @return
     */
    public List<PmsRole> listByPermissionId(Long permissionId) {
        return pmsRoleDao.listByPermissionId(permissionId);
    }

    /**
     * 根据角色名或者角色编号查询角色
     *
     * @param roleName
     * @param roleCode
     * @return
     */
    public PmsRole getByRoleNameOrRoleCode(String roleName, String roleCode) {
        return pmsRoleDao.getByRoleNameOrRoleCode(roleName, roleCode);
    }

    /**
     * 删除
     *
     * @param roleId
     */
    public void delete(Long roleId) {
        pmsRoleDao.deleteById(roleId);
    }
}
