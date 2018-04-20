package servlet;

import service.QuizService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuizAddServlet extends HttpServlet {

    QuizService ts = QuizService.QUIZ_SERVICE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        boolean formChecked = Boolean.parseBoolean(req.getParameter("formChecked"));

        if(formChecked){
            String subject = req.getParameter("subject");
            String theme = req.getParameter("theme");
            ts.addQuiz(subject, theme);
            resp.sendRedirect("list");
            return;
        }
            RequestDispatcher rd = req.getRequestDispatcher("/view/quiz.jsp");
            rd.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
