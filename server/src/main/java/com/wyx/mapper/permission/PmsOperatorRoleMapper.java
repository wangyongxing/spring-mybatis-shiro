package com.wyx.mapper.permission;

import com.wyx.common.mapper.Mapper;
import com.wyx.domain.permission.PmsOperatorRole;
import com.wyx.domain.permission.PmsOperatorRoleConditions;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsOperatorRoleMapper extends Mapper<PmsOperatorRole> {
    int countByExample(PmsOperatorRoleConditions example);

    int deleteByExample(PmsOperatorRoleConditions example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsOperatorRole record);

    int insertSelective(PmsOperatorRole record);

    List<PmsOperatorRole> selectByExample(PmsOperatorRoleConditions example);

    PmsOperatorRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsOperatorRole record, @Param("example") PmsOperatorRoleConditions example);

    int updateByExample(@Param("record") PmsOperatorRole record, @Param("example") PmsOperatorRoleConditions example);

    int updateByPrimaryKeySelective(PmsOperatorRole record);

    int updateByPrimaryKey(PmsOperatorRole record);
}