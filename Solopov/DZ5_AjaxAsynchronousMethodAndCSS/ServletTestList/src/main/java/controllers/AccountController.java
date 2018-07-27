package controllers;

import dao.UserDAOReal;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.logging.Logger;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class AccountController {
    private static Logger log = Logger.getLogger(AccountController.class.getName());

    @Autowired
    UserService userService;
    @Autowired
    UserDAOReal userDAO;


    @RequestMapping(method = GET, value = "/auth")
    public String authorization() {
        return "Authorization";
    }

    @RequestMapping(method = POST, value = "/auth")
    public String authorization(@RequestParam("login") String login,
                                    @RequestParam("password") String password,
                                    HttpSession session) {
        log.info("Current login:" + login + " Current password:" + password);
        if (userService.authorizate(login,password)) {
            User user= userDAO.findByLogin(login);
            session.setAttribute("login", user.getLogin());
            return "redirect:/quizlist";
        }
        return "Authorization";
    }

    @RequestMapping(method = GET, value = "/reg")
    public ModelAndView registration() {
        return new ModelAndView("Registration","userReg",new User());
    }

    @RequestMapping(method = POST, value = "/reg")
    public String registration(@ModelAttribute("userReg") @Valid User user, BindingResult bindingResult,
                               HttpSession session) {
        if(bindingResult.hasErrors()) return "Registration";
        if (userDAO.findByLogin(user.getLogin()) == null) {
            userDAO.persist(user);
            session.setAttribute("login", user.getLogin());
            return "welcomepage";
        }
        return "Registration";
    }

    @RequestMapping(method = GET, value = "logout")
    public String logout(HttpSession session) {
        session.setAttribute("login", null);
        session.removeAttribute("login");
        return "Authorization";
    }

}