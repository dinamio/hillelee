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

@WebServlet("/send")
public class AddQuizTopicController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputQuizSubject = req.getParameter("Subject");
        String inputQuizTopic = req.getParameter("Theme");

        QuizService.getListQuiz().add(new QuizTopicBean(inputQuizSubject, inputQuizTopic));

        req.getRequestDispatcher(String.valueOf(Pages.FIST_PAGE)).include(req,resp);
    }
}
