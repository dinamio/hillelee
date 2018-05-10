package command;

import service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginCommand implements Command{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        LoginService service = new LoginService();
        String login = req.getParameter("login");
        String pass = req.getParameter("password");
        if(service.isRegistered(login, pass)){
            HttpSession session = req.getSession();
            session.setAttribute("user", login);
            resp.sendRedirect("quizzes");
        } else {
            resp.sendRedirect("registration.jsp");
        }
    }

    @Override
    public String toString() {
        return "LoginCommand";
    }
}
