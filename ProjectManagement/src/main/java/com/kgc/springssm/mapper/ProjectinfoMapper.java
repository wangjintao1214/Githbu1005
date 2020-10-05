package com.kgc.springssm.mapper;

import com.kgc.springssm.pojo.Projectinfo;
import com.kgc.springssm.pojo.ProjectinfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectinfoMapper {
    int countByExample(ProjectinfoExample example);

    int deleteByExample(ProjectinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Projectinfo record);

    int insertSelective(Projectinfo record);

    List<Projectinfo> selectByExample(ProjectinfoExample example);

    Projectinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Projectinfo record, @Param("example") ProjectinfoExample example);

    int updateByExample(@Param("record") Projectinfo record, @Param("example") ProjectinfoExample example);

    int updateByPrimaryKeySelective(Projectinfo record);

    int updateByPrimaryKey(Projectinfo record);
}