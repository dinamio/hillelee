package com.kuznetsov.controllers;

import com.kuznetsov.dao.impl.daoServices.UserDao;
import com.kuznetsov.entities.UserDataFromForm;
import com.kuznetsov.entities.Users;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller()
public class LoginController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private Users users;

    @RequestMapping(method = GET, value = "/")
    public String getLoginView(HttpSession session) {

        if (session.getAttribute("wrongMessage") == null) {
            session.setAttribute("wrongMessage", "");
        }

        return "login";
    }


    @RequestMapping(method = POST, value = "/")
    public String userDataProcessing(@ModelAttribute("userDataFromLoginJSP") UserDataFromForm userDataFromForm, HttpSession session) throws IOException, ServletException {

        String buttonType = userDataFromForm.getSubmit();

        if (buttonType.equals("Sign up")) {
            return signUpButtonAction(userDataFromForm, session);
        }
        if (buttonType.equals("Sign in")) {
            return signInButtonAction(userDataFromForm, session);
        }
        return null;
    }


    private String signUpButtonAction(UserDataFromForm userDataFromForm, HttpSession session) {

        boolean userExist = userDao.getUserFromDB(userDataFromForm.getLogin()) != null;

        if (!userExist) {
            String salt = BCrypt.gensalt();
            String pwd = BCrypt.hashpw(userDataFromForm.getPwd(), salt);

            users = new Users(userDataFromForm.getLogin(), pwd, salt);

            userDao.saveCredentialsToDB(users);
            setCredentialsToSession(users, session);

            return "redirect:/quiz";

        } else {
            String wrongMessage = "<p>Username already exist</p>";
            session.setAttribute("wrongMessage", wrongMessage);

            return "login";
        }
    }

    private String signInButtonAction(UserDataFromForm userDataFromForm, HttpSession session) {
        Boolean checkPwd = false;
        users = userDao.getUserFromDB(userDataFromForm.getLogin());

        if (users != null) {
            checkPwd = (users.getPwd().equals(BCrypt.hashpw(userDataFromForm.getPwd(), users.getSalt())));
        }

        if (checkPwd) {
            setCredentialsToSession(users, session);

            return "redirect:/quiz";
        } else {
            setWrongMessageToLoginJSP(session);
            return "login";
        }
    }

    private void setWrongMessageToLoginJSP(HttpSession session) {

        String wrongMessage = "<p>Your login or password are wrong. Try again.</p> <p>New user - press Sign up</p>";
        session.setAttribute("wrongMessage", wrongMessage);
    }

    private void setCredentialsToSession(Users users, HttpSession session) {

        session.setAttribute("login", users.getLogin());
        session.setAttribute("pwd", users.getPwd());
    }
}
