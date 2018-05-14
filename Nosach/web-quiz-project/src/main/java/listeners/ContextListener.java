package listeners;

import dao.connector.DBConnector;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    Logger logger = Logger.getLogger(ContextListener.class);

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context=sce.getServletContext();
        String dburl="jdbc:mysql://localhost:3306/quiz-project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String dbusername= "root";
        String dbpassword="admin";

        logger.info("Trying to connect "+dburl);
        DBConnector.createConnection(dburl, dbusername, dbpassword);
        logger.info("Connection Establised.........");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        DBConnector.closeConnection();
    }

}
