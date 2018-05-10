package filters;

import model.User;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class QuizFilter implements Filter {
    private static final String PARAM_NAME_USERNAME = "name";
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    private static final String ERROR_EMPTY_LOGIN_PASS_MESSAGE = "One of the entered values are empty";
    private static final String ERROR_LOGIN_PASS_MESSAGE = "Incorrect login or password";
    private static final String ERROR_LOGIN_EXIST_MESSAGE = "User with such login already exist";

    private static final String LOGIN_PAGE = "/login.jsp";
    private static final String REGISTRATION_PAGE = "/registration.jsp";

    private static UserService userService = UserService.getInstance();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if (session.getAttribute("userID") != null) {
            if ("logout".equals(action)) {
                session.invalidate();
                request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
            } else {
                filterChain.doFilter(servletRequest,servletResponse);
            }
        } else {

            String login = request.getParameter(PARAM_NAME_LOGIN);
            String password = request.getParameter(PARAM_NAME_PASSWORD);

            switch (action) {
                case "login":
                    if (isEmptyParameters(login, password) || isNullParameters(login, password)) {
                        forwardWithErrorMessage(request, response, LOGIN_PAGE,  ERROR_EMPTY_LOGIN_PASS_MESSAGE);
                    } else if (!userService.isUserExist(login, password)) {
                        forwardWithErrorMessage(request, response, LOGIN_PAGE, ERROR_LOGIN_PASS_MESSAGE);
                    } else {
                        session.setAttribute("userID", session.getId());
                        session.setAttribute("login", login);
                        filterChain.doFilter(servletRequest, servletResponse);
                    }
                    break;
                case "registration":
                    String name = request.getParameter(PARAM_NAME_USERNAME);

                    if (isEmptyParameters(name, login, password) || isNullParameters(name, login, password)) {
                        forwardWithErrorMessage(request, response, REGISTRATION_PAGE, ERROR_EMPTY_LOGIN_PASS_MESSAGE);
                    } else if (userService.isLoginExist(login)) {
                        forwardWithErrorMessage(request, response, REGISTRATION_PAGE, ERROR_LOGIN_EXIST_MESSAGE);
                    } else {
                        userService.addUser(new User(name, login, password));
                        request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
                    }
                    break;
            }

        }
    }

    private void forwardWithErrorMessage(HttpServletRequest request, HttpServletResponse response, String page, String errorMessage) throws ServletException, IOException {
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

    private boolean isNullParameters(String... parameters) {
        return Arrays.stream(parameters).anyMatch(Objects::isNull);
    }
}

