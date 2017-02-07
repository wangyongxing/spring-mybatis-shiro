package com.wyx.common.interceptor;

import com.wyx.common.domain.BaseDomain;
import com.wyx.common.utils.ArrayUtils;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Date;


@SuppressWarnings({"rawtypes", "unchecked"})
public class MapperInterceptor implements MethodBeforeAdvice {


    @Override
    public void before(Method method, Object[] objs, Object object) throws Throwable {
        Class<?> entityClass = method.getDeclaringClass();

        BaseDomain domain = null;
        if (ArrayUtils.isNotEmpty(objs)) {
            for (Object obj : objs) {
                if (obj instanceof BaseDomain) {
                    domain = (BaseDomain) obj;
                    break;
                }
            }
        }

        if (domain != null) {
            // 数据库创建和更新时间添加
            if (method.getName().startsWith("insert")) {
                Date createdAt = domain.getCreateTime();
                if (createdAt == null) {
                    domain.setCreateTime(new Date());
                }
                domain.setEditTime(new Date());
            } else if (method.getName().startsWith("update")) {
                domain.setEditTime(new Date());
            }


        }
    }
}

