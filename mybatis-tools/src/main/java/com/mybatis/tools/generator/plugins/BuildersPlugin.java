package com.mybatis.tools.generator.plugins;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * @author jared
 * @Description:自动生成domain对象构建器
 * @date Dec 31, 2014 3:28:40 PM
 */
public class BuildersPlugin extends PluginAdapter {

    private Set<String> mappers = new HashSet<String>();

    private boolean caseSensitive = false;

    @Override
    public boolean validate(List<String> warnings) {
        return Boolean.TRUE;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        generateBuilders(introspectedTable, topLevelClass);
        return Boolean.TRUE;
    }

    @Override
    public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        generateBuilders(introspectedTable, topLevelClass);
        return Boolean.TRUE;
    }

    @Override
    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        generateBuilders(introspectedTable, topLevelClass);
        return Boolean.TRUE;
    }

    private void generateBuilders(IntrospectedTable introspectedTable, TopLevelClass topLevelClass) {
        List<IntrospectedColumn> columns;
        if (introspectedTable.getRules().generateRecordWithBLOBsClass()) {
            columns = introspectedTable.getNonBLOBColumns();
        } else {
            columns = introspectedTable.getAllColumns();
        }

        for (IntrospectedColumn column : columns) {
            Method method = new Method();
            method.setVisibility(JavaVisibility.PUBLIC);
            method.setReturnType(new FullyQualifiedJavaType(introspectedTable.getFullyQualifiedTable()
                    .getDomainObjectName()));
            method.setName(column.getJavaProperty());
            method.addParameter(new Parameter(column.getFullyQualifiedJavaType(), "value"));
            method.addBodyLine("this." + column.getJavaProperty() + " = value;");
            method.addBodyLine("return this;");
            topLevelClass.addMethod(method);
        }
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        String mappers = this.properties.getProperty("mappers");
        if (StringUtility.stringHasValue(mappers)) {
            for (String mapper : mappers.split(",")) {
                this.mappers.add(mapper);
            }
        } else {
            throw new RuntimeException("Mapper插件缺少必要的mappers属性!");
        }
        String caseSensitive = this.properties.getProperty("caseSensitive");
        if (StringUtility.stringHasValue(caseSensitive)) {
            this.caseSensitive = caseSensitive.equalsIgnoreCase("TRUE");
        }
    }

    /**
     * 生成的Mapper接口
     *
     * @param interfaze
     * @param topLevelClass
     * @param introspectedTable
     * @return
     */
    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        //获取实体类
        FullyQualifiedJavaType entityType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        //import接口
        for (String mapper : mappers) {
            interfaze.addImportedType(new FullyQualifiedJavaType(mapper));
            interfaze.addSuperInterface(new FullyQualifiedJavaType(mapper + "<" + entityType.getShortName() + ">"));
        }
        //import实体类
        interfaze.addImportedType(entityType);
        return true;
    }

}
