package logging;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LoggerManager {

    private static final Logger LOGGER;

    static {
        LOGGER = LogManager.getLogger("HWLogger");
        BasicConfigurator.configure();
    }

    public static Logger getLogger(){
        return LOGGER;
    }



}
