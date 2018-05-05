package borysov.controller;

import borysov.entity.User;
import borysov.exception.DAOException;
import borysov.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(LoginController.class);
    UserService service = new UserService();


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

        User currentUser = null;
        try {
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
