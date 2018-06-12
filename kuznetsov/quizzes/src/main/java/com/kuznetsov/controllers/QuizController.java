package com.kuznetsov.controllers;


import com.kuznetsov.entities.QuizDataFromForm;
import com.kuznetsov.services.QuestionAggregator;
import com.kuznetsov.services.QuizServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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
    private QuestionAggregator questionAggregator;


    @RequestMapping(method = GET, value = "")
    public String GetQuizJsp(HttpServletRequest req){

        if (req.getSession().getAttribute("login") != null && req.getSession().getAttribute("pwd") != null) {
            req.setAttribute("list", services.getAllQuizzes());
            return "quizzes";
        }
        return "login";
    }

    @RequestMapping(method = POST, value = "")
    public String addNewQuiz(@ModelAttribute("dataFromForm") QuizDataFromForm dataFromForm, HttpServletRequest req) {
        String theme = dataFromForm.getTheme();

        if (theme != null) {
            String subject = dataFromForm.getSubject();
            String sessionLogin = (String) req.getSession().getAttribute("login");

            Map<String, Byte> questionMap = new HashMap<>(questionAggregator.createQuestionsMap(req));
            services.addNewQuiz(subject, theme, sessionLogin, questionMap);
            req.setAttribute("list", services.getAllQuizzes());
        }
        return "quizzes";
    }

    @RequestMapping(method = DELETE, value = "/{id}")
    public String deleteQuiz(@PathVariable("id") Integer id, HttpServletRequest req){

        logger.info("Delete from quiz table id #" + id);
        services.removeQuizById(id);
        req.setAttribute("list", services.getAllQuizzes());
        return "quizzes";
    }
}
