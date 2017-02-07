package com.wyx.mapper.permission;

import com.wyx.common.mapper.Mapper;
import com.wyx.domain.permission.PmsRole;
import com.wyx.domain.permission.PmsRoleConditions;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsRoleMapper extends Mapper<PmsRole> {
    int countByExample(PmsRoleConditions example);

    int deleteByExample(PmsRoleConditions example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsRole record);

    int insertSelective(PmsRole record);

    List<PmsRole> selectByExample(PmsRoleConditions example);

    PmsRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsRole record, @Param("example") PmsRoleConditions example);

    int updateByExample(@Param("record") PmsRole record, @Param("example") PmsRoleConditions example);

    int updateByPrimaryKeySelective(PmsRole record);

    int updateByPrimaryKey(PmsRole record);

    List<PmsRole> listByPermissionId(Long permissionId);
}