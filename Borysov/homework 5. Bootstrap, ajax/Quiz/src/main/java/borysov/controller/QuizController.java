package borysov.controller;

import borysov.entity.*;
import borysov.service.QuizService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class QuizController {
    private static final Logger LOGGER = Logger.getLogger(QuizController.class);
    @Autowired
    QuizService service;

    @GetMapping(value = "showQuizzes")
    public String showQuizzes(Model model) {
        LOGGER.info("ShowQuizzes");
        model.addAttribute("listOfQuizzes", service.getListOfQuizzes());
        return "showQuizzes";
    }
    @GetMapping(value = "createQuiz")
    public String createQuiz(Model model) {
        model.addAttribute("quiz", new Quiz());
        return "createQuiz";
    }

    @DeleteMapping(value = "delete/{id}")
    public String getDelete(@PathVariable("id") int id) {
        LOGGER.info("DeleteQuiz");

        service.removeQuizById(id);
        return "redirect:showQuizzes";
    }


    @RequestMapping(method = POST, value = "addQuiz")
    public String addQuiz(@ModelAttribute("quiz")  @Valid Quiz quiz, BindingResult bindingResult, Principal principal) {
        if(bindingResult.hasErrors())
        {
            return "createQuiz";
        }
        LOGGER.info("AddQuiz" + principal.getName());
        quiz.setAuthor(principal.getName());
        service.addQuiz(quiz);

        return "redirect:showQuizzes";
    }

    @RequestMapping(method = GET, value = "addQuestionAndAnswers")
    public String getAddPage(WebRequest req, HttpSession session) {
        LOGGER.info("getAddPage");
        String quizId = req.getParameter("quiz_id");
        session.setAttribute("quizId", quizId);

        return "addQuestion";
    }

    @RequestMapping(method = POST, value = "mainPage")
    public String getMainPage() {
        LOGGER.info("mainPage");
        return "mainPage";
    }

    @RequestMapping(method = POST, value = "addQuestionAndAnswers")
    public String addQuestionAndAnswers(ServletRequest req, HttpSession session) {
        LOGGER.info("post");
        String quizId = (String) session.getAttribute("quizId");
        String quationText = req.getParameter("text_question_field");

        List<Answer> answersList = new ArrayList<Answer>();

        for (int i = 1; i <= 4; i++) {
            String answerText = req.getParameter("answer_field" + i);
            boolean isRight = (req.getParameter("answer_is_right_field" + i) != null);

            Answer answer = new Answer();
            answer.setText(answerText);
            answer.setRightAnswer(isRight);
            answersList.add(answer);
        }

        service.addQuestionAndAnswers(Integer.valueOf(quizId), quationText, answersList);
        return "redirect:showQuizzes";
    }

}
