package com.wyx.mapper.permission;

import com.wyx.common.mapper.Mapper;
import com.wyx.domain.permission.PmsPermission;
import com.wyx.domain.permission.PmsPermissionConditions;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsPermissionMapper extends Mapper<PmsPermission> {
    int countByExample(PmsPermissionConditions example);

    int deleteByExample(PmsPermissionConditions example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsPermission record);

    int insertSelective(PmsPermission record);

    List<PmsPermission> selectByExample(PmsPermissionConditions example);

    PmsPermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsPermission record, @Param("example") PmsPermissionConditions example);

    int updateByExample(@Param("record") PmsPermission record, @Param("example") PmsPermissionConditions example);

    int updateByPrimaryKeySelective(PmsPermission record);

    int updateByPrimaryKey(PmsPermission record);
}