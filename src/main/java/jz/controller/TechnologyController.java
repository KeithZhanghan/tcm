package jz.controller;

import jz.dao.TechnologyDao;
import jz.dao.TechnologyTypeDao;
import jz.entity.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class TechnologyController {
    @Autowired
    TechnologyDao technologyDao;
    @Autowired
    TechnologyTypeDao technologyTypeDao;
    @RequestMapping("/technologyList.do")
    public String getTechnologyList(HttpSession session){
        //只需要获取一次technologyType
        session.setAttribute("technologyTypeList", technologyTypeDao.getallTechnologyType());
        listFlush(session);
        session.setAttribute("page","technologyList.jsp");
        session.setAttribute("search","/searchTechnology.do");
        return "/index";
    }

    @RequestMapping("/searchTechnology.do")
    public String searchTechnology(HttpSession session,String search){
        session.setAttribute("technologyList",technologyDao.search(search));
        session.setAttribute("keyword",search);
        return "/index";
    }

    @RequestMapping("/addTechnology.do")
    public String addTechnology(HttpSession session, Technology technology){
        technologyDao.addTechnology(technology);
        listFlush(session);
        return "/technologyList";
    }

    @RequestMapping("/deleteTechnology.do")
    public String deleteTechnology(HttpSession session,String id){
        technologyDao.deleteTechnology(id);
        listFlush(session);
        return "/technologyList";
    }
    @RequestMapping("/editTechnology.do")
    public String edit(Technology technology,HttpSession session){
        technology.setIsValid(1);
        technologyDao.update(technology);
        listFlush(session);
        return "/technologyList";
    }


     private void listFlush(HttpSession session){
        session.setAttribute("technologyList",technologyDao.getallTechnology());

    }
}
