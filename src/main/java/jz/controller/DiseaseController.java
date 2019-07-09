package jz.controller;

import jz.dao.DiseaseDao;
import jz.dao.DiseaseTypeDao;
import jz.dao.SymptomDao;
import jz.entity.Disease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class DiseaseController {

    @Autowired
    DiseaseDao diseaseDao;
    @Autowired
    DiseaseTypeDao diseaseTypeDao;
    @Autowired
    SymptomDao symptomDao;

    @RequestMapping("/diseaseList.do")
    public String getDiseaseList(HttpSession session) {
        //只需要获取一次diseaseType
        session.setAttribute("diseaseTypeList", diseaseTypeDao.getallDiseaseType());
        session.setAttribute("symptomList", symptomDao.getallSymptom());
        listFlush(session);
        session.setAttribute("page", "diseaseList.jsp");
        session.setAttribute("search", "/searchDisease.do");
        return "/index";
    }

    @RequestMapping("/searchDisease.do")
    public String searchDisease(HttpSession session, String search) {
        session.setAttribute("diseaseList", diseaseDao.search(search));
        session.setAttribute("keyword",search);
        return "/index";
    }

    @RequestMapping("/addDisease.do")
    public String addDisease(HttpSession session, Disease disease) {
        diseaseDao.addDisease(disease);
        listFlush(session);
        return "/diseaseList";
    }

    @RequestMapping("/deleteDisease.do")
    public String deleteDisease(HttpSession session, String id) {
        diseaseDao.deleteDisease(id);
        listFlush(session);
        return "/diseaseList";
    }

    @RequestMapping("/editDisease.do")
    public String edit(Disease disease, HttpSession session) {
        disease.setIsValid(1);
        diseaseDao.updateDisease(disease);
        listFlush(session);
        return "/diseaseList";
    }


    private void listFlush(HttpSession session) {
        session.setAttribute("diseaseList", diseaseDao.getallDisease());
    }
}
