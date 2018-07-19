
package controllers;

import Entities.Registration;
import Services.QuizService;
import Services.RegistrationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class AuthenticationController {

    @Autowired
    RegistrationService registrationService;

    private final Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping(method = RequestMethod.POST, value = "registration")
    public String registration(@ModelAttribute("userToAdd")Registration registration){
        logger.info(registration.toString());
        if (registrationService.checkLoginIsUntaken(registration.getLogin())){
            registrationService.addUser(registration);
            return "Authorization";
        }
        else { return "Error";}
    }

    @RequestMapping(method = RequestMethod.POST, value = "login")
    public String login (@ModelAttribute("userToLogin") Registration registration, HttpSession session){
        logger.info(registration.toString());
        System.out.println(registration.toString());
        if (registrationService.checkLoginAndPassword(registration.getLogin(), registration.getPassword())) {
            session.setAttribute("login", registration.getLogin());
            session.setAttribute("password", registration.getPassword());
            session.setAttribute("user", new Registration(registration.getLogin(), registration.getPassword()));
            return "redirect:/show_all";
        }
        else return "Error";
    }

    @RequestMapping(method = RequestMethod.GET, value = "logout")
    public String logout(HttpSession session){
        if (session.getAttribute("login") != null) {
            session.removeAttribute("login");
            session.removeAttribute("password");
            session.removeAttribute("user");
            return "Authorization";
        }
        else return "redirect:/show_all";

    }

    @RequestMapping(method = RequestMethod.GET, value = "redirect_authorization")
    public String redirectToAuthorization(){
        return "Authorization";
    }
}

