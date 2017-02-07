package com.wyx.dao.permission;

import com.wyx.common.dao.BaseDao;
import com.wyx.common.page.Page;
import com.wyx.domain.permission.PmsOperator;
import com.wyx.domain.permission.PmsOperatorConditions;
import com.wyx.domain.permission.PmsPermission;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wangyongxing
 * Date: 16/8/31
 * Time: 下午5:01
 * To change this template use File | Settings | File Templates.
 */
public interface PmsOperatorDao extends BaseDao<PmsOperator, PmsOperatorConditions> {

    public PmsOperator findOperatorByLoginName(String loginName);


    List<PmsOperator> listByRoleId(Long roleId);


    public List<PmsOperator> listPage(Page page, Map<String, Object> map);
}
