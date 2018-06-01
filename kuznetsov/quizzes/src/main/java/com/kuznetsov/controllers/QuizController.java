package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import services.JspIncluder;
import services.QuestionAggregator;
import services.QuizServices;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@Controller
@RequestMapping(value = "/quiz")
public class QuizController {
    private Logger logger = Logger.getLogger(QuizController.class.getName());
    @Autowired
    private QuizServices services;
    @Autowired
    private JspIncluder jspIncluder;
    @Autowired
    private QuestionAggregator questionAggregator;





    @RequestMapping(method = GET, value = "")
    public void includeJsp(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if (req.getSession().getAttribute("login") != null && req.getSession().getAttribute("pwd") != null) {
            jspIncluder.includeJspToPage(req, resp);
        }
    }

    @RequestMapping(method = POST, value = "")
    public void addNewQuiz(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String theme = req.getParameter("Theme");
        String id = req.getParameter("Id");

        if (theme != null && id == null) {

            String subject = req.getParameter("Subject");
            String sessionLogin = (req.getSession().getAttribute("login")).toString();

            Map<String, String> questionMap = new HashMap<>(questionAggregator.createQuestionsMap(req));
            services.addNewQuiz(subject, theme, sessionLogin, questionMap);
        }
        includeJsp(req, resp);
    }

    @RequestMapping(method = DELETE, value = "")
    public void deleteQuiz(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String id = req.getParameter("id");
        logger.info("Delete from quiz table id #" + id);
        services.removeQuizById(Integer.parseInt(id));
        includeJsp(req, resp);
    }


}
