package ui.usersevlets.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Service {
    public static final String PARAM_NAME_FULL_USER_NAME = "fullName";
    public static final String PARAM_NAME_LOGIN = "login";
    public static final String PARAM_NAME_PASSWORD = "password";

    public static final String ERROR_LOGIN_PASS_MESSAGE = "Incorrect login or password";
    public static final String ERROR_LOGIN_EXIST_MESSAGE = "User with such login already exists";

    private Service() {
    }

    public static void forwardWithErrorMessage(HttpServletRequest request, HttpServletResponse response,
                                               String page, String errorMessage) throws ServletException, IOException {
        switch (errorMessage) {
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
}
