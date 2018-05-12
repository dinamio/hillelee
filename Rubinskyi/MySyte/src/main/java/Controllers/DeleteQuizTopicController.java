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
        String deleteQuizSubject = req.getParameter("Subject");
        String deleteQuizTopic = req.getParameter("Theme");

        System.out.print(deleteQuizSubject + " ");
        System.out.print(deleteQuizTopic);

        QuizService.copyDelete(QuizService.getListQuiz(), new QuizTopicBean(deleteQuizSubject, deleteQuizTopic));

        req.getRequestDispatcher(String.valueOf(Pages.FIST_PAGE)).include(req,resp);
    }
}
