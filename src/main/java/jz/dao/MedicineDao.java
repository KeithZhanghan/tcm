package jz.dao;

import jz.entity.Medicine;
import jz.util.HibernateUtil;
import jz.util.Util;
import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicineDao {
    public List<Medicine> search(String input){
        Criteria criteria= HibernateUtil.openSession().createCriteria(Medicine.class);
        if(!Util.isEmpty(input)){
            Disjunction disjunction= Restrictions.disjunction();
            disjunction.add(Restrictions.like("medicineName","%"+input+"%"));
            disjunction.add(Restrictions.like("medicineDescribe","%"+input+"%"));
            disjunction.add(Restrictions.like("medicineEfficacy","%"+input+"%"));
            criteria.add(disjunction);
            criteria.add(Restrictions.eq("isValid", 1));
        }
        return criteria.list();
    }
    public List<Medicine> getallMedicine(){
        List<Medicine> list=HibernateUtil.openSession().createQuery("from Medicine where isValid=1").list();
        if(null!=list){
            return list;
        }
        return null;

    }

    public boolean addMedicine(Medicine medicine){
        medicine.setIsValid(1);
        if(null!= HibernateUtil.openSession().save(medicine)){
            HibernateUtil.openSession().flush();
            return true;
        }
        return false;
    }

    public boolean deleteMedicine(String id){
        Medicine medicine=(Medicine)HibernateUtil.openSession().get(Medicine.class,id);
        if(null!=medicine){
            medicine.setIsValid(0);
            return update(medicine);
        }
        return false;
    }

    public boolean updateMedicine(Medicine medicine){
        return update(medicine);
    }

    public boolean update(Medicine medicine) {
        try{
            HibernateUtil.openSession().update(medicine);
            HibernateUtil.openSession().flush();
        }catch (Exception e){
            return false;
        }
        return true;
    }


}
