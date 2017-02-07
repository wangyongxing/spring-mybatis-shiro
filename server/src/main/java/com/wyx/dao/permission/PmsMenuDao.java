package com.wyx.dao.permission;

import com.wyx.common.dao.BaseDao;
import com.wyx.domain.permission.PmsMenu;
import com.wyx.domain.permission.PmsMenuConditions;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wangyongxing
 * Date: 16/9/1
 * Time: 下午2:54
 * To change this template use File | Settings | File Templates.
 */
public interface PmsMenuDao extends BaseDao<PmsMenu, PmsMenuConditions> {


    public List getListByParent(Long parentId);

    public List selectByRoleIds(List<String> roldIds);

    public List<PmsMenu> listByParentId(Long parentId);

    List<PmsMenu> getMenuByNameAndIsLeaf(Map<String, Object> map);
}
