package controllers;

import dao.QuizDAOReal;
import dao.UserDAOReal;
import model.Quiz;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

import javax.validation.Valid;
import java.security.Principal;
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

    @RequestMapping(method = GET, value = "/quizlist")
    public String quizList(ModelMap model){
        model.addAttribute("list", quizDAO.findAll());
        model.addAttribute("quizToAdd", new Quiz());
        return "QuizList";
    }

    @RequestMapping(method = POST, value ="/quizlist" )
    public String addQuiz(Model model, Principal principal, @ModelAttribute("quizToAdd") @Valid Quiz quiz,
                           BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("list", quizDAO.findAll());
            return "QuizList"; //
        }
        User user= userDAO.findByLogin(principal.getName());
        user.getQuizzes().add(quiz);
        userDAO.update(user);
        return "redirect:/quizlist";
    }

    @RequestMapping(method = DELETE, value ="quizlist/{id}" )
    public @ResponseBody String deleteQuiz(@PathVariable("id") int id){
        quizDAO.delete(id);
        return "OK";
    }
}
