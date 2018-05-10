package ui.Quiz;

import org.apache.log4j.Logger;
import services.QuizService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuizRemoveServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(QuizRemoveServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        log.info(id);

       new QuizService().removeQuestion(QuizListServlet.quizList,id);
        resp.sendRedirect("/quizlist");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
