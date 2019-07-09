package jz.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibrenateUtil {
    public static SessionFactory getSessionFactory(){
        Configuration configure = new Configuration().configure();
        //2.创建session工厂对象
        SessionFactory sessionFactory = configure.buildSessionFactory();
        //3.开启Session对象


        return sessionFactory;
    }
    //打开并返回一个Session
    public static Session openSession(){
        return getSessionFactory().openSession();
    }

    //关闭Session
    public static void closeSession(Session session){
        if(null != session){
            session.close();
        }
    }
}
