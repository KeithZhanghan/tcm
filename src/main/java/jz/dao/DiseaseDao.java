package jz.dao;

import jz.entity.Disease;
import jz.util.HibernateUtil;
import jz.util.Util;
import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DiseaseDao {

    public List<Disease> search(String input){
        Criteria criteria=HibernateUtil.openSession().createCriteria(Disease.class);
        if(!Util.isEmpty(input)){
            Disjunction disjunction= Restrictions.disjunction();
            disjunction.add(Restrictions.like("diseaseName","%"+input+"%"));
            disjunction.add(Restrictions.like("diseaseReason","%"+input+"%"));
            disjunction.add(Restrictions.like("diseaseDescribe","%"+input+"%"));
            criteria.add(disjunction);
            criteria.add(Restrictions.eq("isValid", 1));
        }
        return criteria.list();
    }
    public List<Disease> getallDisease(){
        List<Disease> list=HibernateUtil.openSession().createQuery("from Disease where isValid=1").list();
        if(null!=list){
            return list;
        }
        return null;

    }

    public boolean addDisease(Disease disease){
        disease.setIsValid(1);
        if(null!= HibernateUtil.openSession().save(disease)){
            HibernateUtil.openSession().flush();
            return true;
        }
        return false;
    }

    public boolean deleteDisease(String id){
        Disease disease=(Disease)HibernateUtil.openSession().get(Disease.class,id);
        if(null!=disease){
            disease.setIsValid(0);
            return update(disease);
        }
        return false;
    }

    public boolean updateDisease(Disease disease){
        return update(disease);
    }

    public boolean update(Disease disease) {
        try{
            HibernateUtil.openSession().update(disease);
            HibernateUtil.openSession().flush();
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
