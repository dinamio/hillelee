package ui.Question;

import entity.Quiz;
import org.apache.log4j.Logger;
import services.QuestionService;
import services.QuizService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionRemoveServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(QuestionRemoveServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        log.info(id);

        new QuestionService().removeQuestion(Quiz.questionSet,id);
        resp.sendRedirect("/questions");
    }
}
