package Controllers;

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
   /* QuizService quizService = new QuizService();*/
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputQuizSubject = req.getParameter("Subject");
        String inputQuizTopic = req.getParameter("Theme");
        System.out.println("!!!!!!!MY STRINGS  "+inputQuizSubject+" "+ inputQuizTopic);

        QuizService.getListQuiz().add(new QuizTopicBean(inputQuizSubject, inputQuizTopic));

        req.getRequestDispatcher("index.jsp").include(req,resp);
    }
}
