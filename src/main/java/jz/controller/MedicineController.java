package jz.controller;

import jz.dao.MedicineDao;
import jz.dao.MedicineTypeDao;
import jz.entity.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MedicineController {
    @Autowired
    MedicineDao medicineDao;
    @Autowired
    MedicineTypeDao medicineTypeDao;

    @RequestMapping("/medicineList.do")
    public String getMedicineList(HttpSession session) {
        //只需要获取一次medicineType
        session.setAttribute("medicineTypeList", medicineTypeDao.getallMedicineType());
        listFlush(session);
        session.setAttribute("page", "medicineList.jsp");
        session.setAttribute("search", "/searchMedicine.do");
        return "/index";
    }

    @RequestMapping("/searchMedicine.do")
    public String searchMedicine(HttpSession session, String search) {
        session.setAttribute("medicineList", medicineDao.search(search));
        session.setAttribute("keyword",search);
        return "/index";
    }

    @RequestMapping("/addMedicine.do")
    public String addMedicine(HttpSession session, Medicine medicine) {
        medicineDao.addMedicine(medicine);
        listFlush(session);
        return "/medicineList";
    }

    @RequestMapping("/deleteMedicine.do")
    public String deleteMedicine(HttpSession session, String id) {
        medicineDao.deleteMedicine(id);
        listFlush(session);
        return "/medicineList";
    }

    @RequestMapping("/editMedicine.do")
    public String edit(Medicine medicine, HttpSession session) {
        medicine.setIsValid(1);
        medicineDao.update(medicine);
        listFlush(session);
        return "/medicineList";
    }


    private void listFlush(HttpSession session) {

        session.setAttribute("medicineList", medicineDao.getallMedicine());

    }
}
