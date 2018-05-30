package Controllers;

import Entities.Pages;
import Entities.QuizTopicBean;
import Services.QuizService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteQuizTopicController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        QuizService.deleteById(QuizService.getListQuiz(), id);

        req.getRequestDispatcher(Pages.FIST_PAGE.getPage()).include(req, resp);
    }
}
