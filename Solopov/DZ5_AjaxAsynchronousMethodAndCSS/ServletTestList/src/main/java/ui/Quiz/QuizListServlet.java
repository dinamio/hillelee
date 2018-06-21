package ui.Quiz;

import hibernate.entity.Quiz;
import hibernate.service.ServiceQuiz;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import services.QuizService;
import ui.Question.QuestionRemoveServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

public class QuizListServlet extends HttpServlet
{
    private static Logger log = Logger.getLogger(QuestionRemoveServlet.class.getName());
    Set<Quiz> quizzes = new LinkedHashSet<>();

    @Autowired
    ServiceQuiz quizService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("list", quizService.findAll());
        RequestDispatcher dispatcher = req.getRequestDispatcher("QuizList.jsp");

        dispatcher.forward(req, resp);
    }
}
