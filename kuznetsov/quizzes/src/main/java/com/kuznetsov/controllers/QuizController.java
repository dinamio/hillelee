package com.kuznetsov.controllers;


import com.kuznetsov.entities.SubjectQuiz;
import com.kuznetsov.services.JspIncluder;
import com.kuznetsov.services.QuestionAggregator;
import com.kuznetsov.services.QuizServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.ServletException;
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
    public void includeJsp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("login") != null && req.getSession().getAttribute("pwd") != null) {
            jspIncluder.includeJspToPage(req, resp);
        }
    }

    @RequestMapping(method = POST, value = "")
    public void addNewQuiz(@ModelAttribute("subjectQuiz") SubjectQuiz subjectQuiz, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String theme = subjectQuiz.getTheme();

        if (theme != null) {

            String subject = subjectQuiz.getSubject();
            String sessionLogin = (String) req.getSession().getAttribute("login");

            Map<String, String> questionMap = new HashMap<>(questionAggregator.createQuestionsMap(req));
            services.addNewQuiz(subject, theme, sessionLogin, questionMap);
        }
        includeJsp(req, resp);
    }

    @RequestMapping(method = DELETE, value = "/{id}")
    public void deleteQuiz(@PathVariable("id") Integer id, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("Delete from quiz table id #" + id);
        services.removeQuizById(id);
        includeJsp(req, resp);
    }
}
