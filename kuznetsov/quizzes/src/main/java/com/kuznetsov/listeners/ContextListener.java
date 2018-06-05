package com.kuznetsov.listeners;


import com.kuznetsov.dao.Connector;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String dburl = "jdbc:mysql://localhost:3306/quiz?useUnicode=true&characterEncoding=UTF8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String dbusername = "user";
        String dbpassword = "user";

        Connector.createConnection(dburl, dbusername, dbpassword);

    }

    public void contextDestroyed(ServletContextEvent sce) {
        Connector.closeConnection();
    }

}
