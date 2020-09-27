package com.osvue.example.mapper;

import com.osvue.example.domain.PePermissionApiExtend;
import com.osvue.example.domain.PePermissionApiExtendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PePermissionApiExtendMapper {
    long countByExample(PePermissionApiExtendExample example);

    int deleteByExample(PePermissionApiExtendExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PePermissionApiExtend record);

    int insertSelective(PePermissionApiExtend record);

    List<PePermissionApiExtend> selectByExample(PePermissionApiExtendExample example);

    PePermissionApiExtend selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PePermissionApiExtend record, @Param("example") PePermissionApiExtendExample example);

    int updateByExample(@Param("record") PePermissionApiExtend record, @Param("example") PePermissionApiExtendExample example);

    int updateByPrimaryKeySelective(PePermissionApiExtend record);

    int updateByPrimaryKey(PePermissionApiExtend record);
}