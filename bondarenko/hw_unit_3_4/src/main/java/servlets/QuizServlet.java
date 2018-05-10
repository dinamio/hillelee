package servlets;

import logging.Log;
import model.Quiz;
import service.QuizService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "quizServlet", urlPatterns = "/quiz")
public class QuizServlet extends HttpServlet {

    QuizService service = new QuizService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Quiz quiz = (Quiz) service.get(name);
        if (quiz != null){
            req.setAttribute("quiz", quiz);
            req.getRequestDispatcher("/quiz.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Log.writeInfo("Removing started...");
        String name = req.getParameter("name");
        try {
            service.remove(name);
            resp.getWriter().printf("Quiz {%s} was removed", name);
            Log.writeInfo("Removing finished.");
        } catch (Exception e){
            Log.writeError(e, "Removing error");
            resp.getWriter().printf("Unable to remove {%s}", name);
        }
    }


}
