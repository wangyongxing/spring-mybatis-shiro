package com.wyx.dao.permission.impl;

import com.wyx.common.dao.impl.BaseDaoImpl;
import com.wyx.dao.permission.PmsMenuDao;
import com.wyx.domain.permission.PmsMenu;
import com.wyx.domain.permission.PmsMenuConditions;
import com.wyx.mapper.permission.PmsMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wangyongxing
 * Date: 16/9/1
 * Time: 下午2:55
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class PmsMenuDaoImpl extends BaseDaoImpl<PmsMenu, PmsMenuConditions> implements PmsMenuDao {

    @Autowired
    PmsMenuMapper mapper;

    @Override
    @Autowired
    public void setMapper() {
        super.setMapper(mapper);
    }

    @Override
    public List getListByParent(Long parentId) {
        PmsMenuConditions conditions = new PmsMenuConditions();
        if (parentId != null) {
            conditions.createCriteria().andParentIdEqualTo(parentId);
        }
        return mapper.selectByExample(conditions);
    }

    @Override
    public List selectByRoleIds(List<String> roldIds) {
        return mapper.selectByRoleIds(roldIds);
    }

    @Override
    public List<PmsMenu> listByParentId(Long parentId) {
        PmsMenuConditions conditions = new PmsMenuConditions();
        conditions.createCriteria().andParentIdEqualTo(parentId);
        return mapper.selectByExample(conditions);
    }

    @Override
    public List<PmsMenu> getMenuByNameAndIsLeaf(Map<String, Object> map) {
        PmsMenuConditions conditions = new PmsMenuConditions();
        conditions.createCriteria().addByMap(map);
        return mapper.selectByExample(conditions);
    }
}
