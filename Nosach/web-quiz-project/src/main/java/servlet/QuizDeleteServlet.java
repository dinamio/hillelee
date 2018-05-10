package servlet;

import service.QuizService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuizDeleteServlet extends HttpServlet {

    private QuizService ts = QuizService.QUIZ_SERVICE;

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        ts.removeQuiz(id);

        resp.sendRedirect("/list");
    }


}
