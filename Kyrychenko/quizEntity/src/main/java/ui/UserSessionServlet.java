package ui;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/authentication")
public class UserSessionServlet extends HttpServlet {
    private static final String PARAM_NAME_USERNAME = "name";
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    private static final String LOGIN_PAGE = "/login.jsp";
    private static final String REGISTRATION_PAGE = "/registration.jsp";

    private static final String ERROR_EMPTY_LOGIN_PASS_MESSAGE = "One of the entered values are empty";
    private static final String ERROR_LOGIN_PASS_MESSAGE = "Incorrect login or password";
    private static final String ERROR_LOGIN_EXIST_MESSAGE = "User with such login already exist";

    private static UserService userService = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String name = req.getParameter(PARAM_NAME_USERNAME);
        String login = req.getParameter(PARAM_NAME_LOGIN);
        String password = req.getParameter(PARAM_NAME_PASSWORD);

        String action = req.getParameter("action");

        switch (action) {
            case "login":
                if (isEmptyParameters(login, password)) {
                    forwardWithErrorMessage(req, resp, LOGIN_PAGE,  ERROR_EMPTY_LOGIN_PASS_MESSAGE);
                } else if (!userService.isUserAccountFound(login, password)) {
                    forwardWithErrorMessage(req, resp, LOGIN_PAGE, ERROR_LOGIN_PASS_MESSAGE);
                } else {
                    session.setAttribute("userID", session.getId());
                    session.setAttribute("login", login);
                    resp.sendRedirect("/quiz");
                }
                break;
            case "registration":
                if (isEmptyParameters(name, login, password)) {
                    forwardWithErrorMessage(req, resp, REGISTRATION_PAGE, ERROR_EMPTY_LOGIN_PASS_MESSAGE);
                } else if (userService.isLoginExist(login)) {
                    forwardWithErrorMessage(req, resp, REGISTRATION_PAGE, ERROR_LOGIN_EXIST_MESSAGE);
                } else {
                    userService.addUser(new User(name, login, password));
                    req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
                }
                break;
            case "logout":
                session.invalidate();
                req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
                break;
        }
    }

    private void forwardWithErrorMessage(HttpServletRequest request, HttpServletResponse response,
                                         String page, String errorMessage) throws ServletException, IOException {
        switch (errorMessage) {
            case ERROR_EMPTY_LOGIN_PASS_MESSAGE:
                request.setAttribute("wrongAction", ERROR_EMPTY_LOGIN_PASS_MESSAGE);
                break;
            case ERROR_LOGIN_PASS_MESSAGE:
                request.setAttribute("errorLoginPassMessage", ERROR_LOGIN_PASS_MESSAGE);
                break;
            case ERROR_LOGIN_EXIST_MESSAGE:
                request.setAttribute("loginExist", ERROR_LOGIN_EXIST_MESSAGE);
                break;
            default:
                break;
        }
        request.getRequestDispatcher(page).forward(request, response);
    }

    private boolean isEmptyParameters(String... parameters) {
        return Arrays.stream(parameters).anyMatch(String::isEmpty);
    }
}
