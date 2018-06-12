package servlets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import services.JspIncluder;
import services.QuestionAggregator;
import services.QuizServices;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@WebServlet("/quiz")
public class QuizServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(QuizServlet.class.getName());
    @Autowired
    private QuizServices services;
    @Autowired
    private JspIncluder jspIncluder;
    @Autowired
    private QuestionAggregator questionAggregator;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("login") != null && req.getSession().getAttribute("pwd") != null) {
            jspIncluder.includeJspToPage(req, resp);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String theme = req.getParameter("Theme");
        String id = req.getParameter("Id");

        if (theme != null && id == null) {

            String subject = req.getParameter("Subject");
            String sessionLogin = (req.getSession().getAttribute("login")).toString();

            Map<String, String> questionMap = new HashMap<>(questionAggregator.createQuestionsMap(req));
            services.addNewQuiz(subject, theme, sessionLogin, questionMap);
        }
        doGet(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        logger.info("Delete from quiz table id #" + id);
        services.removeQuizById(Integer.parseInt(id));
        doGet(req, resp);
    }


}