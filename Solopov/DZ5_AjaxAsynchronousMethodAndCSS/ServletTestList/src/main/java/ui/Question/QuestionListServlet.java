package ui.Question;

import hibernate.service.ServiceQuiz;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import services.QuestionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionListServlet extends HttpServlet {
    @Autowired
    ServiceQuiz quizService;

    private static Logger log = Logger.getLogger(QuestionAddServlet.class.getName());

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("id")!=null) {
            int id = Integer.parseInt(req.getParameter("id"));
            QuestionService.currentQuiz = quizService.findById(id);
        }
        req.setAttribute("list", QuestionService.currentQuiz.getQuestions());

        RequestDispatcher dispatcher = req.getRequestDispatcher("QuestionList.jsp");
        dispatcher.forward(req, resp);

    }

}