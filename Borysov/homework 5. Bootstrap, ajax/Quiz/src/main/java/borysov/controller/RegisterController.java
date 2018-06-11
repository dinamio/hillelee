package borysov.controller;

import borysov.entity.User;
import borysov.service.QuizService;
import borysov.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet{
    private static final Logger LOGGER = Logger.getLogger(RegisterController.class);
    @Autowired
    private UserService service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LOGGER.info("Registration");

        String login = req.getParameter("login_field");
        String password = req.getParameter("password_field");
        String email = req.getParameter("name_field");

        User newUser = new User(login,password,email);
         LOGGER.info(newUser);
        service.registerUser(newUser);

        resp.sendRedirect("index.jsp");

    }
}
