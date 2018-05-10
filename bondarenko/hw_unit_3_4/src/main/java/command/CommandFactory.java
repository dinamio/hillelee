package command;

public class CommandFactory {

    public static Command create(String key) throws Exception{
        switch (key) {
            case "login":
                return new LoginCommand();
            case "logout":
                return new LogoutCommand();
            default:
                throw new Exception(String.format("Unsupported command {%s}", key));
        }
    }
}
