package services;

import servlets.QuizServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;


public class JspIncluder {
    Logger logger = Logger.getLogger(QuizServlet.class.getName());
    private QuizServices services = QuizServices.getInstance();

    public void includeJspToPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher logoutButton = req.getRequestDispatcher("/view/logOutButton.jsp");
        RequestDispatcher formDispatcher = req.getRequestDispatcher("/view/quizCreationForms.jsp");
        RequestDispatcher responseDispatcher = req.getRequestDispatcher("/view/quizViewTable.jsp");

        logoutButton.include(req, resp);
        formDispatcher.include(req, resp);

        req.setAttribute("list", services.getSubjectQuizList());

        responseDispatcher.include(req, resp);
    }
}
