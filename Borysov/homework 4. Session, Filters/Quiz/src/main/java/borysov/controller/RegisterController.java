package borysov.controller;

import borysov.entity.User;
import borysov.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet{
    private static final Logger LOGGER = Logger.getLogger(RegisterController.class);
    private UserService service = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LOGGER.info("Registration");

        String login = req.getParameter("login_field");
        String password = req.getParameter("password_field");
        String email = req.getParameter("email_field");

        User newUser = new User(login,password,email);

        service.addUser(newUser);

        resp.sendRedirect("index.jsp");

    }
}
