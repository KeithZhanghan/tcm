package jz.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class HibernateUtil {
    private static Session session;

    @Autowired
    public void setSession(SessionFactory sessionFactory){
           if(null==session){
               session=sessionFactory.openSession();
           }
    }

    public static Session openSession(){
      return session;
    }

    //关闭Session
    public static void closeSession(Session session){
        if(null != session){
            session.close();
        }
    }

}
