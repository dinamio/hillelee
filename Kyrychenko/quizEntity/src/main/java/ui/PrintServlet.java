package ui;

import model.Quiz;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PrintServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("list", QuizServlet.quizAdder.getQuizList());
        req.getRequestDispatcher("/outputQuiz.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String subject = req.getParameter("subject");
        String topic = req.getParameter("topic");

        QuizServlet.quizAdder.deleteQuiz(new Quiz(subject, topic));

        req.getRequestDispatcher("/outputQuiz.jsp").forward(req, resp);
    }
}
