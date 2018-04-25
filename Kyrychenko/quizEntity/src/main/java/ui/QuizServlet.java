package ui;

import model.Quiz;
import service.QuizAdder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class QuizServlet extends HttpServlet {
    protected static QuizAdder quizAdder = new QuizAdder();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String subject = req.getParameter("subject");
        String topic = req.getParameter("topic");

        quizAdder.addQuiz(new Quiz(subject, topic));

        req.getRequestDispatcher("/inputQuiz.jsp").forward(req, resp);
    }


    // getting page with adding a book form
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/inputQuiz.jsp");
        dispatcher.forward(req, resp);
    }
}
