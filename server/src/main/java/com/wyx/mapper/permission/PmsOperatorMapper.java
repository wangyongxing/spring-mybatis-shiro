package com.wyx.mapper.permission;

import com.wyx.common.mapper.Mapper;
import com.wyx.domain.permission.PmsOperator;
import com.wyx.domain.permission.PmsOperatorConditions;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsOperatorMapper extends Mapper<PmsOperator> {
    int countByExample(PmsOperatorConditions example);

    int deleteByExample(PmsOperatorConditions example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsOperator record);

    int insertSelective(PmsOperator record);

    List<PmsOperator> selectByExample(PmsOperatorConditions example);

    PmsOperator selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsOperator record, @Param("example") PmsOperatorConditions example);

    int updateByExample(@Param("record") PmsOperator record, @Param("example") PmsOperatorConditions example);

    int updateByPrimaryKeySelective(PmsOperator record);

    int updateByPrimaryKey(PmsOperator record);

    List<PmsOperator> listByRoleId(@Param("roleId") Long roleId);
}