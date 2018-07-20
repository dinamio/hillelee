package controllers;

import Entities.Pages;
import Entities.QuizTopic;
import Entities.Registration;
import Services.QuizService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
//@RequestMapping("/quizes")
public class QuizController {

    @Autowired
    QuizService quizService;

   private final Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping(method = RequestMethod.GET, value = "show_all")
    public String showQuizes(Model model){
        model.addAttribute("all_questions", quizService.getListQuiz());
        return "/index";
    }

    @RequestMapping(method = RequestMethod.POST, value = "send")
    public String addQuizTopic (@ModelAttribute("quizToAdd")QuizTopic quizTopic, HttpSession session){
        quizService.addQuiz(quizTopic, (Registration) session.getAttribute("user"));
        return "redirect:/show_all";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "delete/{deleteId}")
    @ResponseBody
    public void deleteQuizTopic(@PathVariable("deleteId")Integer id){
        quizService.deleteById(id);
    }
}
