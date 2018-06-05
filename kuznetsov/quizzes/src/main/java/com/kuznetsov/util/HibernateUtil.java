package com.kuznetsov.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Logger;

public class HibernateUtil {
    private static Logger logger = Logger.getLogger(HibernateUtil.class.getName());
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            logger.info ("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
