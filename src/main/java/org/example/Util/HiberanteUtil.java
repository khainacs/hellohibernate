package org.example.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HiberanteUtil {
    private static SessionFactory sessionFactory;

//    public static SessionFactory getSessionFactory(){
//        try{
//            Configuration cfg = new Configuration();
//            cfg.configure("hibernate.cfg.xml");
//            if(sessionFactory == null){
//                sessionFactory = cfg.buildSessionFactory();
//            }
//
//        }catch (Throwable ex){
//            ex.getMessage();
//        }
//
//        return sessionFactory;
//    }
//
//    public static void main(String[] args) {
//        getSessionFactory();
//    }

    static {
        // Create a new Configuration object
        Configuration cfg = new Configuration();
        cfg.configure();

        // Get the SessionFactory object from Configuration
        if (sessionFactory == null) {
            sessionFactory = cfg.buildSessionFactory();
        }

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
