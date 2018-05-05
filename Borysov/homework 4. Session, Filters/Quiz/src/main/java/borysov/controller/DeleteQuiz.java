package borysov.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import borysov.entity.*;
import borysov.service.QuizService;
import org.apache.log4j.Logger;

@WebServlet("/DeleteQuiz")
public class DeleteQuiz extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(DeleteQuiz.class);
    QuizService quizService = new QuizService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("DeleteQuiz");

        int id = Integer.valueOf(req.getParameter("id_for_delete_field"));
        LOGGER.info("id " + id);
        quizService.removeQuizById(id);
        req.getSession().setAttribute("listOfQuizzes", quizService.getListOfQuizzes());
        resp.sendRedirect("showQuizzes.jsp");

    }
}
