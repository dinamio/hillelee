package servlet;

import entity.Answer;
import org.apache.log4j.Logger;
import service.builder.QuizBuilder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestionAddServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(QuestionAddServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("questionsCount", 0);
        RequestDispatcher rd = req.getRequestDispatcher("/view/questions-page.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        QuizBuilder quizBuilder = (QuizBuilder) session.getAttribute("builder");

        String question = req.getParameter("question");

        int i =0;
        List<Answer> listOfAnswers = new ArrayList<>();

        while(req.getParameter("answer"+i) != null ){
            boolean checked = false;
            if (req.getParameter("check"+i) != null){
                checked = true;
            }
            listOfAnswers.add(new Answer(req.getParameter("answer"+i), checked));
            i++;
        }

        quizBuilder.addQuestion(question, listOfAnswers);

        if (req.getParameter("save") != null){
            logger.info("Saving Quiz to database!!");
            quizBuilder.saveToDB();
            session.setAttribute("builder", null);
            resp.sendRedirect("/list");
            return;
        }

        String count = req.getParameter("questionsCount").toString();
        int next = Integer.parseInt(count)+1;
        req.setAttribute("questionsCount", next);

        RequestDispatcher rd = req.getRequestDispatcher("/view/questions-page.jsp");
        rd.forward(req, resp);
        return;
    }


}
