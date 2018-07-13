package controllers;

import dao.UserDAOReal;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserService;

import javax.servlet.http.HttpSession;

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
    public String getAuthorization() {
        return "Authorization";
    }

    @RequestMapping(method = POST, value = "/auth")
    public String postAuthorization(@RequestParam("login") String login,
                                    @RequestParam("password") String password,
                                    HttpSession session) {
        log.info("Current login:" + login + " Current password:" + password);
        if ((login != null || password != null) && (userService.authorizate(login,password))) {
            User user= userDAO.findByLogin(login);
            userService.setCurrentUser(user);
            session.setAttribute("login", user.getLogin());
            return "redirect:/quizlist";
        }
        return "Authorization";
    }

    @RequestMapping(method = GET, value = "/reg")
    public String getRegistration() {
        return "Registration";
    }

    @RequestMapping(method = POST, value = "/reg")
    public String postRegistration(@ModelAttribute("userReg") User user,
                                   HttpSession session) {
        if (user.getLogin() == null || user.getPassword() == null) return "Registration";
        if (session.getAttribute("login") != null) session.setAttribute("login", null);
        if (userDAO.findByLogin(user.getLogin()) == null) {
            userDAO.persist(user);
            userService.setCurrentUser(user);
            session.setAttribute("login", user.getLogin());
            return "redirect:/quizlist";
        }
        return "Registration";
    }

    @RequestMapping(method = GET, value = "logout")
    public String getLogout(HttpSession session) {
        userService.setCurrentUser(null);
        session.setAttribute("login", null);
        session.removeAttribute("login");
        return "Authorization";
    }

}