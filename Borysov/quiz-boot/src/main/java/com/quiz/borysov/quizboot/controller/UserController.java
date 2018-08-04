package com.quiz.borysov.quizboot.controller;


import com.quiz.borysov.quizboot.entity.User;
import com.quiz.borysov.quizboot.exception.DAOException;
import com.quiz.borysov.quizboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService service;

    @RequestMapping(method = GET, value = "register")
    public String getRegistrationPage() {
        return "register";
    }

    @PostMapping(value = "register")
    public String doRegistration(@ModelAttribute("regModel") User newUser) {
        LOGGER.info(String.valueOf(newUser));
        try {
            service.registerUser(newUser);
            return "index";
        } catch (DAOException e) {
            LOGGER.error("doRegistration",e);
            return "register";
        }

    }

    @RequestMapping(method = GET, value = "login")
    public String getLoginPage(Model model, HttpSession session){
        String loginError = (String) session.getAttribute("message");

        if (loginError != null) {
            model.addAttribute("errorLogIn", "errorLogIn");
            session.removeAttribute("message");
        }
        return "index";
    }

    @RequestMapping(method = POST, value = "login")
    public String doLogin(WebRequest req, HttpSession session){
        LOGGER.info("Log in");

        String login = req.getParameter("login_field");
        String password = req.getParameter("password_field");

        try {
            User currentUser = null;
            currentUser = service.getUserByLoginAndPass(login, password);
            session.setAttribute("currentUser", currentUser);
            return "mainPage";
        } catch (DAOException e) {
            LOGGER.error("Login or password entered incorrectly!", e);
            session.setAttribute("errorLogIn", "errorLogIn");
            return "redirect:login-get";
        }
    }

    @RequestMapping(method = GET, value = "logout")
    public String doLogout(HttpSession session){
        LOGGER.info("Log out");
        session.invalidate();
        return "redirect:login-get";
    }

    @RequestMapping(method = GET, value = "mainPage")
    public String doLogout(){
        return "mainPage";
    }
}
