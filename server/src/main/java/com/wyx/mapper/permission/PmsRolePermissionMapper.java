package com.wyx.mapper.permission;

import com.wyx.common.mapper.Mapper;
import com.wyx.domain.permission.PmsRolePermission;
import com.wyx.domain.permission.PmsRolePermissionConditions;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsRolePermissionMapper extends Mapper<PmsRolePermission> {
    int countByExample(PmsRolePermissionConditions example);

    int deleteByExample(PmsRolePermissionConditions example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsRolePermission record);

    int insertSelective(PmsRolePermission record);

    List<PmsRolePermission> selectByExample(PmsRolePermissionConditions example);

    PmsRolePermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsRolePermission record, @Param("example") PmsRolePermissionConditions example);

    int updateByExample(@Param("record") PmsRolePermission record, @Param("example") PmsRolePermissionConditions example);

    int updateByPrimaryKeySelective(PmsRolePermission record);

    int updateByPrimaryKey(PmsRolePermission record);
}