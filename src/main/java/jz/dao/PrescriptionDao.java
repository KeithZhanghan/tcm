package jz.dao;

import jz.entity.Prescription;
import jz.util.HibernateUtil;
import jz.util.Util;
import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrescriptionDao {
    public List<Prescription> search(String input){
        Criteria criteria= HibernateUtil.openSession().createCriteria(Prescription.class);
        if(!Util.isEmpty(input)){
            Disjunction disjunction= Restrictions.disjunction();
            disjunction.add(Restrictions.like("prescriptionName","%"+input+"%"));
            disjunction.add(Restrictions.like("prescriptionDescribe","%"+input+"%"));
             criteria.add(disjunction);
            criteria.add(Restrictions.eq("isValid", 1));
        }
        return criteria.list();
    }
    public List<Prescription> getallPrescription(){
        List<Prescription> list=HibernateUtil.openSession().createQuery("from Prescription where isValid=1").list();
        if(null!=list){
            return list;
        }
        return null;

    }

    public boolean addPrescription(Prescription prescription){
        prescription.setIsValid(1);
        if(null!= HibernateUtil.openSession().save(prescription)){
            HibernateUtil.openSession().flush();
            return true;
        }
        return false;
    }

    public boolean deletePrescription(String id){
        Prescription prescription=(Prescription)HibernateUtil.openSession().get(Prescription.class,id);
        if(null!=prescription){
            prescription.setIsValid(0);
            return update(prescription);
        }
        return false;
    }

    public boolean updatePrescription(Prescription prescription){
        return update(prescription);
    }

    public boolean update(Prescription prescription) {
        try{
            HibernateUtil.openSession().update(prescription);
            HibernateUtil.openSession().flush();
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
