package com.wyx.dao.permission.impl;

import com.wyx.common.dao.impl.BaseDaoImpl;
import com.wyx.common.page.Page;
import com.wyx.dao.permission.PmsOperatorDao;
import com.wyx.domain.permission.PmsOperator;
import com.wyx.domain.permission.PmsOperatorConditions;
import com.wyx.mapper.permission.PmsOperatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wangyongxing
 * Date: 16/8/31
 * Time: 下午5:04
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class PmsOperatorDaoImpl extends BaseDaoImpl<PmsOperator, PmsOperatorConditions> implements PmsOperatorDao {


    @Autowired
    private PmsOperatorMapper mapper;

    @Override
    @Autowired
    public void setMapper() {
        super.setMapper(mapper);
    }

    @Override
    public PmsOperator findOperatorByLoginName(String loginName) {
        PmsOperatorConditions conditions = new PmsOperatorConditions();
        conditions.createCriteria().andLoginNameEqualTo(loginName);
        List<PmsOperator> list = mapper.selectByExample(conditions);
        return list.get(0);
    }

    @Override
    public List<PmsOperator> listByRoleId(Long roleId) {
        return mapper.listByRoleId(roleId);
    }

    @Override
    public List<PmsOperator> listPage(Page page, Map<String, Object> map) {
        PmsOperatorConditions conditions = new PmsOperatorConditions();
        conditions.createCriteria().addByMap(map);
        if (page != null) {
            page.setTotalNum(mapper.countByExample(conditions));
            conditions.setPage(page);
        }
        return mapper.selectByExample(conditions);
    }
}
