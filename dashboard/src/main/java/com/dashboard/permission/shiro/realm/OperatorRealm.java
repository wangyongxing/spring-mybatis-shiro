/*
 * Copyright 2015-2102 RonCoo(http://www.roncoo.com) Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dashboard.permission.shiro.realm;

import com.wyx.common.enums.PublicStatusEnum;
import com.wyx.domain.permission.PmsOperator;
import com.wyx.service.permission.PmsOperatorRoleService;
import com.wyx.service.permission.PmsOperatorService;
import com.wyx.service.permission.PmsRolePermissionService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * 自定义realm .
 * <p>
 * 龙果学院：www.roncoo.com
 *
 * @author：shenjialong
 */
public class OperatorRealm extends AuthorizingRealm {

    @Autowired
    private PmsOperatorService pmsOperatorService;
    @Autowired
    private PmsOperatorRoleService pmsOperatorRoleService;
    @Autowired
    private PmsRolePermissionService pmsRolePermissionService;

    @SuppressWarnings("unchecked")
    @Override//获取授权信息
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String loginName = (String) principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        PmsOperator operator = (PmsOperator) session.getAttribute("PmsOperator");
        if (operator == null) {
            operator = pmsOperatorService.findOperatorByLoginName(loginName);
            session.setAttribute("PmsOperator", operator);
        }
        // 根据登录名查询操作员
        Long operatorId = operator.getId();
        // 查询角色信息
        Set<String> roles = (Set<String>) session.getAttribute("ROLES");
        if (roles == null || roles.isEmpty()) {
            roles = pmsOperatorRoleService.getRoleCodeByOperatorId(operatorId);
            session.setAttribute("ROLES", roles);
        }
        authorizationInfo.setRoles(roles);
        // 根据用户名查询权限
        Set<String> permisstions = (Set<String>) session.getAttribute("PERMISSIONS");
        if (permisstions == null || permisstions.isEmpty()) {
            permisstions = pmsRolePermissionService.getPermissionsByOperatorId(operatorId);
            session.setAttribute("PERMISSIONS", permisstions);
        }

        authorizationInfo.setStringPermissions(permisstions);
        return authorizationInfo;
    }

    @Override
    // 验证的核心方法(获取身份验证相关信息)
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String loginName = (String) token.getPrincipal();
        if (StringUtils.isEmpty(loginName.trim())) {
            throw new UnknownAccountException();// 没找到帐号
        }

        // 根据登录名查询操作员
        PmsOperator operator = pmsOperatorService.findOperatorByLoginName(loginName);

        if (operator == null) {
            throw new UnknownAccountException();// 没找到帐号
        }

        if (PublicStatusEnum.UNACTIVE.equals(operator.getStatus())) {
            throw new LockedAccountException(); // 帐号锁定
        }

        // 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(operator.getLoginName(), // 登录名
                operator.getLoginPwd(), // 密码
                ByteSource.Util.bytes(operator.getCredentialsSalt()), // salt=username+salt
                getName() // realm name
        );

        return authenticationInfo;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}
