package util;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static final Logger logger = Logger.getLogger(HibernateUtils.class);

    private final static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure(/*new File("hibernate.cgf.xml"*/)
                    .buildSessionFactory();
        }
        catch (Throwable ex){
            logger.info("Session factory creation failed"+ ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
