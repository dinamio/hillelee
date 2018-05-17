package logging;

public class Log {

    private Log(){
    }

    public static void writeInfo(String format, Object ... args){
        LoggerManager.getLogger().info(String.format(format, args));
    }

    public static void writeTrace(String format, Object ... args){
        LoggerManager.getLogger().trace(String.format(format, args));
    }

    public static void writeDebag(String format, Object ... args){
        LoggerManager.getLogger().debug(String.format(format, args));
    }

    public static void writeError(Throwable t, String format, Object ... args){
        LoggerManager.getLogger().error(String.format(format, args), t);
    }

    public static void writeError(String format, Object ... args){
        LoggerManager.getLogger().error(String.format(format, args));
    }
}
