package ui.usersevlets;

import model.User;
import service.UserService;
import ui.usersevlets.service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    public static final String REGISTRATION_PAGE = "/registration.jsp";

    private static UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(REGISTRATION_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter(Service.PARAM_NAME_USERNAME);
        String login = req.getParameter(Service.PARAM_NAME_LOGIN);
        String password = req.getParameter(Service.PARAM_NAME_PASSWORD);

        if (Service.isEmptyParameters(name, login, password)) {
            Service.forwardWithErrorMessage(req, resp, REGISTRATION_PAGE, Service.ERROR_EMPTY_LOGIN_PASS_MESSAGE);
        } else if (userService.isLoginExist(login)) {
            Service.forwardWithErrorMessage(req, resp, REGISTRATION_PAGE, Service.ERROR_LOGIN_EXIST_MESSAGE);
        } else {
            userService.addUser(new User(name, login, password));
            resp.sendRedirect("/authentication");
        }
    }
}
