package borysov.controller;

import borysov.entity.User;
import borysov.exception.DAOException;
import borysov.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(LoginController.class);

    @Autowired
    UserService service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginError = (String) req.getSession().getAttribute("errorLogIn");

        if (loginError != null) {
            req.setAttribute("errorLogIn", "errorLogIn");
            req.getSession().removeAttribute("errorLogIn");
        }

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Log in");

        String login = request.getParameter("login_field");
        String password = request.getParameter("password_field");

        try {
            User currentUser = null;
            currentUser = service.getUserByLoginAndPass(login, password);
            request.getSession().setAttribute("currentUser", currentUser);
            response.sendRedirect("mainPage.jsp");
        } catch (DAOException e) {
            LOGGER.error("Login or password entered incorrectly!", e);
            request.getSession().setAttribute("errorLogIn", "errorLogIn");
            response.sendRedirect("/LoginController");
        }

    }

}
