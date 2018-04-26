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
                doPost(req,resp);
                break;
            case "view":
                req.setAttribute("list", quizService.getQuizList());
                req.getRequestDispatcher("/outputQuiz.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        String subject = req.getParameter("subject");
        String topic = req.getParameter("topic");

        switch (action == null ? "add" : action) {
            case "add":
                if(subject != null && topic != null) {
                    quizService.addQuiz(new Quiz(subject, topic));
                }
                req.setAttribute("size", quizService.getQuizList().size());
                req.getRequestDispatcher("/inputQuiz.jsp").forward(req, resp);
                break;
            case "delete":
                String[] stringsId = req.getParameterValues("id");
                int[] id = Arrays.stream(stringsId).mapToInt(Integer::parseInt).toArray();
                QuizServlet.quizService.deleteQuiz(id);

                req.setAttribute("list", quizService.getQuizList());
                req.getRequestDispatcher("/outputQuiz.jsp").forward(req, resp);
                break;
            default:
                doGet(req, resp);
                break;
        }
    }
}
