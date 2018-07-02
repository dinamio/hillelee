package com.kuznetsov.controllers;

import com.kuznetsov.dao.impl.daoServices.UserDao;
import com.kuznetsov.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller()
public class LoginController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private User user;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(method = GET, value = "/login")
    public String getLoginView() {
        return "login";
    }

    @RequestMapping(method = GET, value = "/signin")
    public String getSignUpPage(HttpSession session, Model model) {
        model.addAttribute("user", new User());
        if (session.getAttribute("wrongMessage") == null) {
            session.setAttribute("wrongMessage", "");
        }
        return "signin";
    }

    @RequestMapping(method = POST, value = "/signin")
    private String signUpButtonAction( @ModelAttribute @Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "redirect:/signin";
        } else {
            String pwd = passwordEncoder.encode(user.getPwd());
            user.setPwd(pwd);
            user.setRole("USER");
            userDao.saveCredentialsToDB(user);

            return "redirect:/login";
        }

    }
}