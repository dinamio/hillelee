package controllers;

import entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String doLogin(@RequestParam("login") String login, @RequestParam("pass") String password, HttpSession session){

        User user = userService.getUser(login);

        if (login == null || password==null || user == null){
            return "redirect:login";
        }

        PasswordEncoder encoder= new BCryptPasswordEncoder();
        if (encoder.matches(password, user.getPassword())) {
            logger.info("User "+login+" found in db and authorized ");
            session.setAttribute("authorized", "true");
            session.setAttribute("login", login);
            return "redirect:list";
        }
        else {
            logger.info("Wrong password for user "+login);
            return "redirect:login";
        }
    }

    @RequestMapping(method = GET, value = "logout")
    public String doLogout(HttpSession session){
        logger.info("current session closed for user "+session.getAttribute("login").toString());

        session.invalidate();
        return "redirect:login";
    }
}
