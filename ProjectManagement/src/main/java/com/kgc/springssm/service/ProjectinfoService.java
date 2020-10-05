package com.kgc.springssm.service;

import com.kgc.springssm.pojo.Projectinfo;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-05 13:32
 */
public interface ProjectinfoService {
    List<Projectinfo> selectAll(Integer status,int pageSize,int pageNum);
    Projectinfo selectAllByid(Integer id);
    int upd(Projectinfo projectinfo);
}
