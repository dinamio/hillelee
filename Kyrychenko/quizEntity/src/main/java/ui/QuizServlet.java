package ui;

import model.Quiz;
import service.QuizService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;


public class QuizServlet extends HttpServlet {
    private static QuizService quizService = QuizService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action == null ? "add" : action) {
            case "add":
                req.setAttribute("size", quizService.getQuizList().size());
                req.getRequestDispatcher("/view/inputQuiz.jsp").forward(req, resp);
                break;
            case "view":
                req.setAttribute("list", quizService.getQuizList());
                req.getRequestDispatcher("/view/outputQuiz.jsp").forward(req, resp);
                break;
            default:
                req.getRequestDispatcher("/view/inputQuiz.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        switch (action == null ? "add" : action) {
            case "add":
                String subject = req.getParameter("subject");
                String topic = req.getParameter("topic");
                String user = req.getSession().getAttribute("login").toString();

                quizService.addQuiz(new Quiz(subject, topic, user));
                req.setAttribute("size", quizService.getQuizList().size());
                req.getRequestDispatcher("/view/inputQuiz.jsp").forward(req, resp);
                break;
            case "delete":
                Arrays.stream(req.getParameterValues("id"))
                        .mapToInt(Integer::parseInt)
                        .forEach(id -> quizService.deleteQuiz(id));

                req.setAttribute("list", quizService.getQuizList());
                req.getRequestDispatcher("/view/outputQuiz.jsp").forward(req, resp);
                break;
            default:
                doGet(req, resp);
                break;
        }
    }
}
