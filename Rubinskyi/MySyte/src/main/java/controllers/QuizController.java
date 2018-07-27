package controllers;

import entity.QuizTopic;
import entity.Registration;
import org.springframework.beans.factory.annotation.Qualifier;
import service.QuizService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
//@RequestMapping("/quizes")
public class QuizController {
    private final Logger logger = Logger.getLogger(this.getClass());

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "show_all")
    public String showQuizes(Model model){
        model.addAttribute("all_questions", quizService.getListQuiz());
        return "/index";
    }

    @RequestMapping(method = RequestMethod.POST, value = "send")
    public String addQuizTopic (@ModelAttribute("quizToAdd")QuizTopic quizTopic, HttpSession session){
        logger.info(quizTopic.toString());
        quizService.addQuiz(quizTopic, (Registration) session.getAttribute("user"));
        return "redirect:/show_all";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "delete/{deleteId}")
    @ResponseBody
    public void deleteQuizTopic(@PathVariable("deleteId")Integer id){
        quizService.deleteById(id);
    }
}
