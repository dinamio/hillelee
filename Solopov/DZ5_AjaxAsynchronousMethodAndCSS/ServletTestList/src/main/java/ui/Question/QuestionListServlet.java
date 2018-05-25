package ui.Question;

import entity.Quiz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("list", Quiz.questionSet);
        RequestDispatcher dispatcher = req.getRequestDispatcher("QuestionList.jsp");
        dispatcher.forward(req, resp);
    }
}
