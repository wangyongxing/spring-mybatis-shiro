package com.wyx.service.permission;

import com.wyx.common.page.Page;
import com.wyx.domain.permission.PmsOperator;

import java.util.List;

/*
 * 操作员service接口
 * Created with IntelliJ IDEA.
 * User: wangyongxing
 * Date: 16/8/30
 * Time: 下午2:39
 * To change this template use File | Settings | File Templates.
 */
public interface PmsOperatorService {

    /**
     * 创建pmsOperator
     */
    void saveData(PmsOperator pmsOperator);

    /**
     * 修改pmsOperator
     */
    void updateData(PmsOperator pmsOperator);

    /**
     * 根据id获取数据pmsOperator
     *
     * @param id
     * @return
     */
    PmsOperator getDataById(Long id);

    /**
     * 根据登录名取得操作员对象
     */
    public PmsOperator findOperatorByLoginName(String loginName);

    /**
     * 分页查询pmsOperator
     *
     * @param page
     * @param pmsOperator
     * @return
     */
    List<PmsOperator> listPage(Page page, PmsOperator pmsOperator);

    /**
     * 根据ID删除一个操作员，同时删除与该操作员关联的角色关联信息. type="admin"的超级管理员不能删除.
     *
     * @param operatorId 操作员ID.
     */
    public void deleteOperatorById(Long operatorId);

    /**
     * 根据操作员ID更新操作员密码.
     *
     * @param operatorId
     * @param newPwd     (已进行SHA1加密)
     */
    public void updateOperatorPwd(Long operatorId, String newPwd);

    /**
     * 保存操作員信息及其关联的角色.
     *
     * @param pmsOperator     .
     * @param roleOperatorStr .
     */
    public void saveOperator(PmsOperator pmsOperator, String roleOperatorStr);

    /**
     * 修改操作員信息及其关联的角色.
     *
     * @param pmsOperator     .
     * @param roleOperatorStr .
     */
    void updateOperator(PmsOperator pmsOperator, String roleOperatorStr);

}
