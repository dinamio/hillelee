package Controllers;

import Entities.QuizTopicBean;
import Services.QuizService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/show_all")
public class ShowAllController extends HttpServlet {
   /* QuizService quizService = new QuizService();*/
    /* quizService.getListQuiz(); */// вернуть лист

   /* public List<QuizTopicBean> questionList = Arrays.asList(new QuizTopicBean("Math", "Integral"),
            new QuizTopicBean("Biology", "Insects"));*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("all_questions", QuizService.getListQuiz());

        req.getRequestDispatcher("index.jsp").include(req,resp);
    }
}
