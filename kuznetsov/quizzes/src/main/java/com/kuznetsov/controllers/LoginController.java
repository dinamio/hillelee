package com.kuznetsov.controllers;

import com.kuznetsov.dao.impl.daoServices.UserDao;
import com.kuznetsov.entities.UserDataFromForm;
import com.kuznetsov.entities.UsersEntity;

import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class LoginController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UsersEntity usersEntity;

    @RequestMapping(method = GET, value = "/")
    public String getLoginView (HttpSession session){

        if (session. getAttribute("wrongMessage") == null) {
            session.setAttribute("wrongMessage", "");
        }

        return "redirect:login";
    }


    @RequestMapping(method = POST, value = "/login.jsp")
    public void userDataProcessing(@ModelAttribute("userDataFromLoginJSP") UserDataFromForm userDataFromForm, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String buttonType = userDataFromForm.getSubmit();

        if (buttonType.equals("Sign up")) {
            signUpButtonAction(userDataFromForm, req, resp);
        }
        if (buttonType.equals("Sign in")) {
            signInButtonAction(userDataFromForm, req, resp);
        }
    }

    private void signUpButtonAction(UserDataFromForm userDataFromForm, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        boolean userExist = userDao.getUserFromDB(userDataFromForm.getLogin()) != null;

        if (!userExist) {
            String salt = BCrypt.gensalt();
            String pwd = BCrypt.hashpw(userDataFromForm.getPwd(), salt);

            usersEntity = new UsersEntity(userDataFromForm.getLogin(), pwd, salt);

            userDao.saveCredentialsToDB(usersEntity);
            setCredentialsToSession(usersEntity, req);
            resp.sendRedirect("/quiz");

        } else {
            String wrongMessage = "<p>Username already exist</p>";
            HttpSession session = req.getSession();
            session.setAttribute("wrongMessage", wrongMessage);
            getLoginView(session);
        }
    }

    private void signInButtonAction(UserDataFromForm userDataFromForm, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Boolean checkPwd = false;
        usersEntity = userDao.getUserFromDB(userDataFromForm.getLogin());

        if (usersEntity != null) {
            checkPwd = (usersEntity.getPwd().equals(BCrypt.hashpw(userDataFromForm.getPwd(), usersEntity.getSalt())));
        }

        if (checkPwd) {
            setCredentialsToSession(usersEntity, req);
            resp.sendRedirect("/quiz");
        } else {
            setWrongMessageToLoginJSP(req, resp);
        }
    }

    private void setWrongMessageToLoginJSP(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String wrongMessage = "<p>Your login or password are wrong. Try again.</p> <p>New user - press Sign up</p>";
        HttpSession session = req.getSession();
        session.setAttribute("wrongMessage", wrongMessage);

        getLoginView(session);
    }

    private void setCredentialsToSession(UsersEntity usersEntity, HttpServletRequest req) {

        req.getSession().setAttribute("login", usersEntity.getLogin());
        req.getSession().setAttribute("pwd", usersEntity.getPwd());
    }
}
