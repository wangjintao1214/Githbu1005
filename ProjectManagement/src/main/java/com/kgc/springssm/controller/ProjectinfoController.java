package com.kgc.springssm.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.springssm.pojo.Projectinfo;
import com.kgc.springssm.service.ProjectinfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-05 13:33
 */
@Controller
public class ProjectinfoController {
    @Resource
    ProjectinfoService projectinfoService;

    @RequestMapping("/")
    public String toindex(Integer status,Model model,@RequestParam(value = "pageNum",defaultValue = "1") int pageNum){
        int pageSize=2;
        List<Projectinfo> projectinfos = projectinfoService.selectAll(status,pageSize,pageNum);
        PageInfo<Projectinfo> pageInfo=new PageInfo<>(projectinfos);
        System.out.println(pageInfo.toString());
        model.addAttribute("projectinfos",projectinfos);
        model.addAttribute("pageInfo",pageInfo);
        return "index";
    }
    @RequestMapping("/toupd")
    public String toupd(Integer id, Model model){
        Projectinfo projectinfo = projectinfoService.selectAllByid(id);
        model.addAttribute("projectinfo",projectinfo);
        return "upd";
    }
    @RequestMapping("/doupd")
    public String doupd(Projectinfo projectinfo, HttpSession session){
        int i = projectinfoService.upd(projectinfo);
        if(i>0){
            session.setAttribute("msg","审核成功！！！");
            return "redirect:/";
        }else {
            session.setAttribute("msg","审核失败！！！");
            return "redirect:/";
        }
    }
}
