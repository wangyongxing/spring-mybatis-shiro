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
package com.dashboard.permission.biz;

import com.wyx.domain.permission.PmsMenu;
import com.wyx.service.permission.PmsMenuService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author System
 * @since 2013-11-12
 */
@Component("pmsMenuBiz")
public class PmsMenuBiz {

    private static final Log log = LogFactory.getLog(PmsMenuBiz.class);

    @Autowired
    private PmsMenuService pmsMenuService;

    /**
     * 获取用于编制菜单时的树.
     */
    @SuppressWarnings("rawtypes")
    public String getTreeMenu(String actionUrl) {
        List treeData = pmsMenuService.getListByParent(null);
        StringBuffer strJson = new StringBuffer();
        recursionTreeMenu("0", strJson, treeData, actionUrl);
        return strJson.toString();
    }

    /**
     * 递归输出树形菜单
     *
     * @param pId
     * @param buffer
     */
    @SuppressWarnings("rawtypes")
    private void recursionTreeMenu(String pId, StringBuffer buffer, List list, String url) {
        if (pId.equals("0")) {
            buffer.append("<ul class=\"tree treeFolder collapse \" >");
        } else {
            buffer.append("<ul>");
        }
        List<PmsMenu> listMap = getSonMenuListByPid(pId, list);
        for (PmsMenu menu : listMap) {
            String id = menu.getId()+"";
            String name = menu.getName();
            String isLeaf = menu.getIsLeaf();// 是否叶子科目
            buffer.append("<li><a onclick=\"onClickMenuNode(" + id + ")\"  href=\"" + url + "?id=" + id + "\" target=\"ajax\" rel=\"jbsxBox\"  value=" + id + ">" + name + "</a>");
            if (!isLeaf.equals("1")) {
                recursionTreeMenu(id, buffer, list, url);
            }
            buffer.append("</li>");
        }
        buffer.append("</ul>");
    }

    /**
     * 根据(pId)获取(menuList)中的所有子菜单集合.
     *
     * @param pId      父菜单ID.
     * @param menuList 菜单集合.
     * @return sonMenuList.
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    private List<PmsMenu> getSonMenuListByPid(String pId, List<PmsMenu> menuList) {
        List<PmsMenu> sonMenuList = new ArrayList<PmsMenu>();
        for (PmsMenu menu : menuList) {
            String parentId = menu.getParentId() + "";
            if (parentId.equals(pId)) {
                sonMenuList.add(menu);
            }

        }
        return sonMenuList;
    }

}