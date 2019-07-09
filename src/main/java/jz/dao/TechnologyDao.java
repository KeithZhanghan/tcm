package jz.dao;

import jz.entity.Technology;
import jz.util.HibernateUtil;
import jz.util.Util;
import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TechnologyDao {
    public List<Technology> search(String input){
        Criteria criteria= HibernateUtil.openSession().createCriteria(Technology.class);
        if(!Util.isEmpty(input)){
            Disjunction disjunction= Restrictions.disjunction();
            disjunction.add(Restrictions.like("technologyName","%"+input+"%"));
            disjunction.add(Restrictions.like("technologyDescribe","%"+input+"%"));
            criteria.add(disjunction);
            criteria.add(Restrictions.eq("isValid", 1));
        }
        return criteria.list();
    }
    public List<Technology> getallTechnology(){
        List<Technology> list=HibernateUtil.openSession().createQuery("from Technology where isValid=1").list();
        if(null!=list){
            return list;
        }
        return null;

    }

    public boolean addTechnology(Technology technology){
        technology.setIsValid(1);
        if(null!= HibernateUtil.openSession().save(technology)){
            HibernateUtil.openSession().flush();
            return true;
        }
        return false;
    }

    public boolean deleteTechnology(String id){
        Technology technology=(Technology)HibernateUtil.openSession().get(Technology.class,id);
        if(null!=technology){
            technology.setIsValid(0);
            return update(technology);
        }
        return false;
    }

    public boolean updateTechnology(Technology technology){
        return update(technology);
    }

    public boolean update(Technology technology) {
        try{
            HibernateUtil.openSession().update(technology);
            HibernateUtil.openSession().flush();
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
