package controllers;

import dao.QuizDAOReal;
import dao.UserDAOReal;
import model.Quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

import java.util.logging.Logger;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class QuizController {
    private static Logger log = Logger.getLogger(QuizController.class.getName());

    @Autowired
    UserService userService;
    @Autowired
    QuizDAOReal quizDAO;
    @Autowired
    UserDAOReal userDAO;

    @RequestMapping(method = GET, value = "quizlist")
    public String getQuizList(Model model){
        model.addAttribute("list", quizDAO.findAll());
        return "QuizList";
    }

    @RequestMapping(method = POST, value ="newquiz" )
    public String postAddQuiz(@ModelAttribute("quizToAdd") Quiz quiz ){
        log.info("QUIZ TITLE:"+quiz.getName()+" QUIZ OBJECTIVE:"+quiz.getObjective());
       // quiz.setId(new Quiz().getId());
        userService.getCurrentUser().getQuizzes().add(quiz);
        userDAO.update(userService.getCurrentUser());
        return "redirect:/quizlist";
    }

    @RequestMapping(method = DELETE, value ="quizlist/{id}" )
    public @ResponseBody String deleteQuiz(@PathVariable("id") int id){
        quizDAO.delete(id);
        return "OK";
    }
}
