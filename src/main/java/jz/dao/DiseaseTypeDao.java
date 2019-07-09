package jz.dao;

import jz.entity.DiseaseType;
import jz.util.Util;
import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

import static jz.util.HibernateUtil.openSession;

@Repository
public class DiseaseTypeDao {

    public List<DiseaseType> search(String input){
        Criteria criteria= openSession().createCriteria(DiseaseType.class);
        if(!Util.isEmpty(input)){
            Disjunction disjunction= Restrictions.disjunction();
            disjunction.add(Restrictions.like("D" +
                    "iseaseTypeName","%"+input+"%"));
            disjunction.add(Restrictions.like("diseaseClassify","%"+input+"%"));
            criteria.add(disjunction);
            criteria.add(Restrictions.eq("isValid", 1));
        }
        return criteria.list();

    }
    public List<DiseaseType> getallDiseaseType(){
        List<DiseaseType> list= openSession().createQuery("from DiseaseType where isValid=1").list();
        if(null!=list){
            return list;
        }
        return null;

    }

    public boolean addDiseaseType(DiseaseType diseaseType){
        diseaseType.setIsValid(1);
        if(null!= openSession().save(diseaseType)){
            openSession().flush();
            return true;
        }
        return false;
    }

    public boolean deleteDiseaseType(String id){
        DiseaseType diseaseType=(DiseaseType) openSession().get(DiseaseType.class,id);
        if(null!=diseaseType){
            diseaseType.setIsValid(0);
            return update(diseaseType);
        }
        return false;
    }

    public boolean updateDiseaseType(DiseaseType DiseaseType){
        return update(DiseaseType);
    }

    public boolean update(DiseaseType diseaseType) {
        try{
            openSession().update(diseaseType);
            openSession().flush();
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
