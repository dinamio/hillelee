package ui;

import model.Quiz;
import model.User;
import service.QuizService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;


public class QuizServlet extends HttpServlet {
    private static final String PARAM_NAME_USERNAME = "name";
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    private static final String LOGIN_PAGE = "/login.jsp";
    private static final String REGISTRATION_PAGE = "/registration.jsp";
    private static final String ADD_QUIZ_PAGE = "/view/inputQuiz.jsp";
    private static final String VIEW_QUIZ_PAGE = "/view/outputQuiz.jsp";

    private static final String ERROR_EMPTY_LOGIN_PASS_MESSAGE = "One of the entered values are empty";
    private static final String ERROR_LOGIN_PASS_MESSAGE = "Incorrect login or password";
    private static final String ERROR_LOGIN_EXIST_MESSAGE = "User with such login already exist";

    private static QuizService quizService = QuizService.getInstance();
    private static UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        String login = req.getParameter(PARAM_NAME_LOGIN);
        String password = req.getParameter(PARAM_NAME_PASSWORD);

        HttpSession session = req.getSession();

        switch (action == null ? "add" : action) {
            case "login":
                if (isEmptyParameters(login, password) || isNullParameters(login, password)) {
                    forwardWithErrorMessage(req, resp, LOGIN_PAGE,  ERROR_EMPTY_LOGIN_PASS_MESSAGE);
                } else if (!userService.isUserExist(login, password)) {
                    forwardWithErrorMessage(req, resp, LOGIN_PAGE, ERROR_LOGIN_PASS_MESSAGE);
                } else {
                    session.setAttribute("userID", session.getId());
                    session.setAttribute("login", login);
                    req.getRequestDispatcher(ADD_QUIZ_PAGE).forward(req, resp);
                }
                break;
            case "logout":
                session.invalidate();
                req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
                break;
            case "add":
                req.setAttribute("size", quizService.getQuizList().size());
                req.getRequestDispatcher(ADD_QUIZ_PAGE).forward(req, resp);
                break;
            case "view":
                req.setAttribute("list", quizService.getQuizList());
                req.getRequestDispatcher(VIEW_QUIZ_PAGE).forward(req, resp);
                break;
            default:
                req.getRequestDispatcher(ADD_QUIZ_PAGE).forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        String login = req.getParameter(PARAM_NAME_LOGIN);
        String password = req.getParameter(PARAM_NAME_PASSWORD);

        switch (action == null ? "add" : action) {
            case "registration":
                String name = req.getParameter(PARAM_NAME_USERNAME);

                if (isEmptyParameters(name, login, password) || isNullParameters(name, login, password)) {
                    forwardWithErrorMessage(req, resp, REGISTRATION_PAGE, ERROR_EMPTY_LOGIN_PASS_MESSAGE);
                } else if (userService.isLoginExist(login)) {
                    forwardWithErrorMessage(req, resp, REGISTRATION_PAGE, ERROR_LOGIN_EXIST_MESSAGE);
                } else {
                    userService.addUser(new User(name, login, password));
                    req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
                }
                break;
            case "add":
                String subject = req.getParameter("subject");
                String topic = req.getParameter("topic");
                String user = req.getSession().getAttribute("login").toString();

                quizService.addQuiz(new Quiz(subject, topic, user));
                req.setAttribute("size", quizService.getQuizList().size());
                req.getRequestDispatcher(ADD_QUIZ_PAGE).forward(req, resp);
                break;
            case "delete":
                Arrays.stream(req.getParameterValues("id"))
                        .mapToInt(Integer::parseInt)
                        .forEach(id -> quizService.deleteQuiz(id));

                req.setAttribute("list", quizService.getQuizList());
                req.getRequestDispatcher(VIEW_QUIZ_PAGE).forward(req, resp);
                break;
            default:
                doGet(req, resp);
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

    private boolean isNullParameters(String... parameters) {
        return Arrays.stream(parameters).anyMatch(Objects::isNull);
    }
}
