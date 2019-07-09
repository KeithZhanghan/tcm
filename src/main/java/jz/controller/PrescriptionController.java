package jz.controller;

import jz.dao.MedicineDao;
import jz.dao.PrescriptionDao;
import jz.entity.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PrescriptionController {
    @Autowired
    PrescriptionDao prescriptionDao;
    @Autowired
    MedicineDao medicineDao;

    @RequestMapping("prescriptionList.do")
    public String getPrescriptionList(HttpSession session) {
        session.setAttribute("medicineList", medicineDao.getallMedicine());
        listFlush(session);
        session.setAttribute("page", "prescriptionList.jsp");
        session.setAttribute("search", "/searchPrescription.do");
        return "/index";
    }

    @RequestMapping("/searchPrescription.do")
    public String searchPrescription(HttpSession session, String search) {
        session.setAttribute("prescriptionList", prescriptionDao.search(search));
        session.setAttribute("keyword",search);
        return "/index";
    }

    @RequestMapping("/addPrescription.do")
    public String addPrescription(HttpSession session, Prescription prescription) {
        prescriptionDao.addPrescription(prescription);
        listFlush(session);
        return "/prescriptionList";
    }

    @RequestMapping("/deletePrescription.do")
    public String deletePrescription(HttpSession session, String id) {
        prescriptionDao.deletePrescription(id);
        listFlush(session);
        return "/prescriptionList";
    }

    @RequestMapping("/editPrescription.do")
    public String edit(Prescription prescription, HttpSession session) {
        prescription.setIsValid(1);
        prescriptionDao.update(prescription);
        listFlush(session);
        return "/prescriptionList";
    }


    private void listFlush(HttpSession session) {
        session.setAttribute("prescriptionList", prescriptionDao.getallPrescription());

    }

}
