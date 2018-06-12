package ui.Quiz;

import hibernate.entity.Quiz;
import hibernate.service.ServiceQuiz;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import services.QuizService;
import services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuizAddServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(QuizRemoveServlet.class.getName());
    @Autowired
    ServiceQuiz quizService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean formAddTest = Boolean.parseBoolean(req.getParameter("formCreateQuiz"));

        if (formAddTest) {
            String testTitle = req.getParameter("testTitle");
            String objective = req.getParameter("objective");
            Quiz quiz = new Quiz(UserService.getCurrentUser(),testTitle, objective);
            quizService.persist(quiz);
        }//end formAddTest

        resp.sendRedirect("/quizlist");
    }
}
