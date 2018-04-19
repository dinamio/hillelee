package borysov.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import borysov.entity.*;

@WebServlet("/AddQuiz")
public class AddQuiz extends HttpServlet {
    List<Quiz> listOfQuizzes = new ArrayList<Quiz>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String subject = request.getParameter("subject_field");
        String theme = request.getParameter("theme_field");
        Quiz quiz = new Quiz(subject, theme);
        listOfQuizzes.add(quiz);
        request.getSession().setAttribute("listOfQuizzes", listOfQuizzes);
        System.out.println("add" + listOfQuizzes);
        response.sendRedirect("showQuizzes.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
