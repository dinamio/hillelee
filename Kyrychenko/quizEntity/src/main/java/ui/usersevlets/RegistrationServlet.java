package ui.usersevlets;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import service.UserService;
import ui.usersevlets.service.Service;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private static final String REGISTRATION_PAGE = "/registration.jsp";
    @Autowired
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(REGISTRATION_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fullName = req.getParameter(Service.PARAM_NAME_FULL_USER_NAME);
        String login = req.getParameter(Service.PARAM_NAME_LOGIN);
        String password = req.getParameter(Service.PARAM_NAME_PASSWORD);

        if (userService.validateUserExists(login)) {
            Service.forwardWithErrorMessage(req, resp, REGISTRATION_PAGE, Service.ERROR_LOGIN_EXIST_MESSAGE);
        }

        userService.addUser(new User(fullName, login, password));
        resp.sendRedirect("/authentication");
    }
}
