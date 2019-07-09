package jz.controller;

import jz.dao.MedicineDao;
import jz.dao.PrescriptionDao;
import jz.dao.SymptomDao;
import jz.dao.TechnologyDao;
import jz.entity.Symptom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class SymptomController {
    @Autowired
    SymptomDao symptomDao;
    @Autowired
    TechnologyDao technologyDao;
    @Autowired
    PrescriptionDao prescriptionDao;
    @Autowired
    MedicineDao medicineDao;

    @RequestMapping("symptomList.do")
    public String getSymptomList(HttpSession session) {
        session.setAttribute("technologyList", technologyDao.getallTechnology());
        session.setAttribute("prescriptionList", prescriptionDao.getallPrescription());
        session.setAttribute("medicineList", medicineDao.getallMedicine());
        listflush(session);
        session.setAttribute("page", "symptomList.jsp");
        session.setAttribute("search", "/searchSymptom.do");
        return "/index";
    }

    @RequestMapping("/searchSymptom.do")
    public String searchSymptom(HttpSession session, String search) {
        session.setAttribute("symptomList", symptomDao.search(search));
        session.setAttribute("keyword",search);
        return "/index";
    }

    @RequestMapping("/addSymptom.do")
    public String addSymptom(HttpSession session, Symptom symptom) {
        System.out.println(symptom.getSymptomMedId());
        symptomDao.addSymptom(symptom);
        listflush(session);
        return "/symptomList";
    }

    @RequestMapping("/deleteSymptom.do")
    public String deleteSymptom(HttpSession session, String id) {
        symptomDao.deleteSymptom(id);
        listflush(session);
        return "/symptomList";
    }

    @RequestMapping("/editSymptom.do")
    public String edit(Symptom symptom, HttpSession session) {
        symptom.setIsValid(1);
        symptomDao.update(symptom);
        listflush(session);
        return "/symptomList";
    }

    public void listflush(HttpSession session) {
        session.setAttribute("symptomList", symptomDao.getallSymptom());

    }
}

