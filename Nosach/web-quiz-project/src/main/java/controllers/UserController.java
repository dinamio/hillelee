package controllers;

import entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import service.UserService;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class UserController {

    Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(method = GET, value = "register")
    public String getRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "register-page";
    }

    @RequestMapping(method = POST, value = "register")
    public String doRegistration(WebRequest req, HttpSession session, @ModelAttribute("user") User user) {

        if(userService.addUser(user)){
            session.setAttribute("login", user.getLogin());
            session.setAttribute("authorized", "true");
            return "redirect:list";
        }
        else return "redirect:register";
    }

    @RequestMapping(method = GET, value = "login")
    public String getLoginPage(){
        return "login-page";
    }

    @RequestMapping(method = POST, value = "login")
    public String doLogin(WebRequest req, HttpSession session){
        session.setAttribute("login", req.getParameter("login"));
        session.setAttribute("pass", req.getParameter("pass"));

        logger.info("User "+req.getParameter("login")+ " added to session");

        return "redirect:list";
    }

    @RequestMapping(method = GET, value = "logout")
    public String doLogout(WebRequest req, HttpSession session){
        logger.info("current session closed for user "+session.getAttribute("login").toString());

        session.invalidate();
        return "redirect:login";
    }
}
