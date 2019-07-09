package jz.dao;

import jz.entity.TechnologyType;
import jz.util.HibernateUtil;
import jz.util.Util;
import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TechnologyTypeDao {
    public List<TechnologyType> search(String input){
        Criteria criteria= HibernateUtil.openSession().createCriteria(TechnologyType.class);
        if(!Util.isEmpty(input)){
            Disjunction disjunction= Restrictions.disjunction();
            disjunction.add(Restrictions.like("technologyTypeName","%"+input+"%"));
            disjunction.add(Restrictions.like("technologyClassify","%"+input+"%"));
            criteria.add(disjunction);
            criteria.add(Restrictions.eq("isValid", 1));
        }
        return criteria.list();
    }
    public List<TechnologyType> getallTechnologyType(){
        List<TechnologyType> list=HibernateUtil.openSession().createQuery("from TechnologyType where isValid=1").list();
        if(null!=list){
            return list;
        }
        return null;

    }

    public boolean addTechnologyType(TechnologyType technologyType){
        technologyType.setIsValid(1);
        if(null!= HibernateUtil.openSession().save(technologyType)){
            HibernateUtil.openSession().flush();
            return true;
        }
        return false;
    }

    public boolean deleteTechnologyType(String id){
        TechnologyType technologyType=(TechnologyType)HibernateUtil.openSession().get(TechnologyType.class,id);
        if(null!=technologyType){
            technologyType.setIsValid(0);
            return update(technologyType);
        }
        return false;
    }

    public boolean updateTechnologyType(TechnologyType technologyType){
        return update(technologyType);
    }

    public boolean update(TechnologyType technologyType) {
        try{
            HibernateUtil.openSession().update(technologyType);
            HibernateUtil.openSession().flush();
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
