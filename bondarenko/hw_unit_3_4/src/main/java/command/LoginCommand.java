package command;

import service.LoginService;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command{

    @Override
    public void execute(HttpServletRequest req) {
        LoginService service = new LoginService();
        String login = req.getParameter("login");
        String pass = req.getParameter("password");
        if(service.isRegistered(login, pass)){

        }

    }
}
