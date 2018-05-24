package ui.Quiz;

import entity.Quiz;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuizAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean formAddTest = Boolean.parseBoolean(req.getParameter("formCreateQuiz"));

        if (formAddTest) {
            String testTitle = req.getParameter("testTitle");
            String objective = req.getParameter("objective");
            Quiz quiz = new Quiz(testTitle, objective);
            quiz.setCreator(req.getSession().getAttribute("login").toString());
            QuizListServlet.quizList.add(quiz);
        }//end formAddTest

        resp.sendRedirect("/quizlist");
    }
}
