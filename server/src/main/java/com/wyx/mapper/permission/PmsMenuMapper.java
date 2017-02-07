package com.wyx.mapper.permission;

import com.wyx.common.mapper.Mapper;
import com.wyx.domain.permission.PmsMenu;
import com.wyx.domain.permission.PmsMenuConditions;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PmsMenuMapper extends Mapper<PmsMenu> {
    int countByExample(PmsMenuConditions example);

    int deleteByExample(PmsMenuConditions example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsMenu record);

    int insertSelective(PmsMenu record);

    List<PmsMenu> selectByExample(PmsMenuConditions example);

    PmsMenu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsMenu record, @Param("example") PmsMenuConditions example);

    int updateByExample(@Param("record") PmsMenu record, @Param("example") PmsMenuConditions example);

    int updateByPrimaryKeySelective(PmsMenu record);

    int updateByPrimaryKey(PmsMenu record);


    List selectByRoleIds(List<String> roles);
}