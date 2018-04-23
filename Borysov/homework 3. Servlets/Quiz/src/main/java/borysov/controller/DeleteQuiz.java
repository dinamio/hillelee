package borysov.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import borysov.entity.*;

@WebServlet("/DeleteQuiz")
public class DeleteQuiz extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Quiz> loadedQuizzes = (ArrayList<Quiz>) req.getSession().getAttribute("listOfQuizzes");
        int id = Integer.valueOf(req.getParameter("id_for_delete_field"));
        loadedQuizzes.remove(id);
        req.getSession().setAttribute("listOfQuizzes", loadedQuizzes);
        resp.sendRedirect("showQuizzes.jsp");
    }
}
