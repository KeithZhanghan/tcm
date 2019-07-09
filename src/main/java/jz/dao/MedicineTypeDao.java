package jz.dao;

import jz.entity.MedicineType;
import jz.util.HibernateUtil;
import jz.util.Util;
import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicineTypeDao {
    public List<MedicineType> search(String input){
        Criteria criteria= HibernateUtil.openSession().createCriteria(MedicineType.class);
        if(!Util.isEmpty(input)){
            Disjunction disjunction= Restrictions.disjunction();
            disjunction.add(Restrictions.like("medicineTypeName","%"+input+"%"));
            disjunction.add(Restrictions.like("medicineClassify","%"+input+"%"));
             criteria.add(disjunction);
            criteria.add(Restrictions.eq("isValid", 1));
        }
        return criteria.list();
    }
    public List<MedicineType> getallMedicineType(){
        List<MedicineType> list=HibernateUtil.openSession().createQuery("from MedicineType where isValid=1").list();
        if(null!=list){
            return list;
        }
        return null;

    }

    public boolean addMedicineType(MedicineType medicineType){
        medicineType.setIsValid(1);
        if(null!= HibernateUtil.openSession().save(medicineType)){
            HibernateUtil.openSession().flush();
            return true;
        }
        return false;
    }

    public boolean deleteMedicineType(String id){
        MedicineType medicineType=(MedicineType)HibernateUtil.openSession().get(MedicineType.class,id);
        if(null!=medicineType){
            medicineType.setIsValid(0);
            return update(medicineType);
        }
        return false;
    }

    public boolean updateMedicineType(MedicineType medicineType){
        return update(medicineType);
    }

    public boolean update(MedicineType medicineType) {
        try{
            HibernateUtil.openSession().update(medicineType);
            HibernateUtil.openSession().flush();
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
