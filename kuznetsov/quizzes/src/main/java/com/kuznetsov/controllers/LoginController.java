package com.kuznetsov.controllers;

import com.kuznetsov.dao.impl.daoServices.UserDao;
import com.kuznetsov.entities.UserDataFromForm;
import com.kuznetsov.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller()
public class LoginController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private Users users;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(method = GET, value = "/login")
    public String getLoginView() {
        return "login";
    }

    @RequestMapping(method = GET, value = "/signin")
    public String getSignUpPage(HttpSession session) {
        if (session.getAttribute("wrongMessage") == null) {
            session.setAttribute("wrongMessage", "");
        }
        return "signin";
    }

    @RequestMapping(method = POST, value = "/signin")
    private String signUpButtonAction(@ModelAttribute("userDataFromLoginJSP") UserDataFromForm userDataFromForm, HttpSession session){

        boolean userExist = userDao.getUserFromDB(userDataFromForm.getLogin()) != null;

        if (!userExist) {
            String pwd = passwordEncoder.encode(userDataFromForm.getPwd());
            users = new Users(userDataFromForm.getLogin(), pwd);
            userDao.saveCredentialsToDB(users);

            return "redirect:/login";

        } else {
            String wrongMessage = "<p>Username already exist</p>";
            session.setAttribute("wrongMessage", wrongMessage);

            return "redirect:/signin";
        }
    }
}
