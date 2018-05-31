package Controllers;

import Entities.Pages;
import Services.QuizService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/show_all")
public class ShowAllController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("all_questions", QuizService.getListQuiz());

        req.getRequestDispatcher(String.valueOf(Pages.FIST_PAGE)).include(req, resp);
    }
}
