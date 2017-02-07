package com.wyx.mapper.permission;

import com.wyx.common.mapper.Mapper;
import com.wyx.domain.permission.PmsMenuRole;
import com.wyx.domain.permission.PmsMenuRoleConditions;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsMenuRoleMapper extends Mapper<PmsMenuRole> {
    int countByExample(PmsMenuRoleConditions example);

    int deleteByExample(PmsMenuRoleConditions example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsMenuRole record);

    int insertSelective(PmsMenuRole record);

    List<PmsMenuRole> selectByExample(PmsMenuRoleConditions example);

    PmsMenuRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsMenuRole record, @Param("example") PmsMenuRoleConditions example);

    int updateByExample(@Param("record") PmsMenuRole record, @Param("example") PmsMenuRoleConditions example);

    int updateByPrimaryKeySelective(PmsMenuRole record);

    int updateByPrimaryKey(PmsMenuRole record);
}