package jz.dao;

import jz.entity.User;
import jz.util.HibernateUtil;
import jz.util.Util;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    private Session getSession()
    {
      return HibernateUtil.openSession();
    }

    public List<User> search(String input){
        Criteria criteria=getSession().createCriteria(User.class);
        if(!Util.isEmpty(input)){
            Disjunction disjunction= Restrictions.disjunction();
            disjunction.add(Restrictions.like("userAccount","%"+input+"%"));
            disjunction.add(Restrictions.like("userName","%"+input+"%"));
            disjunction.add(Restrictions.like("password","%"+input+"%"));
            disjunction.add(Restrictions.like("userGender","%"+input+"%"));
            criteria.add(disjunction);
            criteria.add(Restrictions.eq("isValid", 1));
        }
        return criteria.list();

    }
    public List<User> getallUser(){
        List<User> list=getSession().createQuery("from User where isValid=1").list();
       if(null!=list){
           return list;
       }
       return null;

    }

    public User check(User user){
        Query query= getSession().createQuery("from User where isValid=1 and userAccount=:a and password=:b");
        query.setString("a",user.getUserAccount());
        query.setString("b",user.getPassword());
        List list=query.list();
        if(null!=list){
        return  (User) list.get(0);
        }
        return null;
    }

    public User getByAccount(String account){
        Query query= getSession().createQuery("from User where isValid=1 and userAccount=?");
        query.setString(0,account);
        if(null!=query.list()){
            return  (User) query.list().get(0);
        }
        return null;
    }

    public boolean addUser(User user){
        user.setIsValid(1);
        if(null!=getSession().save(user)){
            getSession().flush();
            return true;
        }
        return false;
    }

    public boolean deleteUser(String account){
        User user=(User) getSession().get(User.class,account);
        if(null!=user){
            user.setIsValid(0);
            try {
                getSession().update(user);
                getSession().flush();
            }catch (Exception e){
                return false;
            }
            return true;
        }
      return false;
    }

    public boolean updateUser(User user){
        try{
            getSession().update(user);
        }catch (Exception e){
            return false;
        }
        return true;
    }


}
