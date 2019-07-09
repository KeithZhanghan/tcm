package jz.dao;

import jz.entity.Symptom;
import jz.util.HibernateUtil;
import jz.util.Util;
import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SymptomDao {
    public List<Symptom> search(String input){
        Criteria criteria= HibernateUtil.openSession().createCriteria(Symptom.class);
        if(!Util.isEmpty(input)){
            Disjunction disjunction= Restrictions.disjunction();
            disjunction.add(Restrictions.like("symptomName","%"+input+"%"));
          criteria.add(disjunction);
            criteria.add(Restrictions.eq("isValid", 1));
        }
        return criteria.list();
    }
    public List<Symptom> getallSymptom(){
        List<Symptom> list=HibernateUtil.openSession().createQuery("from Symptom where isValid=1").list();
        if(null!=list){
            return list;
        }
        return null;

    }

    public boolean addSymptom(Symptom symptom){
        symptom.setIsValid(1);
        if(null!= HibernateUtil.openSession().save(symptom)){
            HibernateUtil.openSession().flush();
            return true;
        }
        return false;
    }

    public boolean deleteSymptom(String id){
        Symptom symptom=(Symptom)HibernateUtil.openSession().get(Symptom.class,id);
        if(null!=symptom){
            symptom.setIsValid(0);
            return update(symptom);
        }
        return false;
    }

    public boolean updateSymptom(Symptom symptom){
        return update(symptom);
    }

    public boolean update(Symptom symptom) {
        try{
            HibernateUtil.openSession().update(symptom);
            HibernateUtil.openSession().flush();
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
