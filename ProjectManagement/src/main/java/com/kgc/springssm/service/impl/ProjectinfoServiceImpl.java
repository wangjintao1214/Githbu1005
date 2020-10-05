package com.kgc.springssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.kgc.springssm.mapper.ProjectinfoMapper;
import com.kgc.springssm.pojo.Projectinfo;
import com.kgc.springssm.pojo.ProjectinfoExample;
import com.kgc.springssm.service.ProjectinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-05 13:32
 */
@Service
public class ProjectinfoServiceImpl implements ProjectinfoService{
    @Resource
    ProjectinfoMapper projectinfoMapper;

    @Override
    public List<Projectinfo> selectAll(Integer status,int pageSize,int pageNum) {
        ProjectinfoExample example=new ProjectinfoExample();
        ProjectinfoExample.Criteria criteria = example.createCriteria();
        if(status!=null||status!=0){
            criteria.andStatusEqualTo(status);
        }
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("id desc");
        List<Projectinfo> projectinfos = projectinfoMapper.selectByExample(example);
        return projectinfos;
    }

    @Override
    public Projectinfo selectAllByid(Integer id) {
        Projectinfo projectinfo = projectinfoMapper.selectByPrimaryKey(id);
        return projectinfo;
    }

    @Override
    public int upd(Projectinfo projectinfo) {
        int i = projectinfoMapper.updateByPrimaryKeySelective(projectinfo);
        return i;
    }
}
