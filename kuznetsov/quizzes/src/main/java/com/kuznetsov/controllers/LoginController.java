package com.kuznetsov.controllers;

import com.kuznetsov.dao.impl.QuizDaoImpl;
import com.kuznetsov.entities.UserDataFromLoginJSP;
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
@RequestMapping(value = "/")

public class LoginController {

    @Autowired
    private QuizDaoImpl quizDao;

    @RequestMapping(method = GET, value = "")
    public void getLoginView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher loginDispatcher = req.getRequestDispatcher("/view/login.jsp");

        HttpSession session = req.getSession();

        if (session.getAttribute("wrongMessage") == null) {
            session.setAttribute("wrongMessage", "");
        }
        loginDispatcher.include(req, resp);
    }


    @RequestMapping(method = POST, value = "")
    public void userDataProcessing(@ModelAttribute("userDataFromLoginJSP") UserDataFromLoginJSP userDataFromLoginJSP, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String buttonType = userDataFromLoginJSP.getSubmit();
        String login = userDataFromLoginJSP.getLogin();
        String pwd = userDataFromLoginJSP.getPwd();

        if (buttonType.equals("Sign up")) {
            signUpButtonAction(login, pwd, req, resp);
        }
        if (buttonType.equals("Sign in")) {
            signInButtonAction(login, pwd, req, resp);
        }
    }

    private void signUpButtonAction(String login, String pwd, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        boolean userExist = quizDao.isUserExistInDB(login);

        if (!userExist) {
            String salt = BCrypt.gensalt();
            String hashPwd = BCrypt.hashpw(pwd, salt);
            quizDao.saveCredentialsToDB(login, hashPwd, salt);
            setCredentialsToSession(login, hashPwd, req, resp);

        } else {
            String wrongMessage = "<p>Username already exist</p>";
            req.getSession().setAttribute("wrongMessage", wrongMessage);
            getLoginView(req, resp);
        }
    }

    private void signInButtonAction(String login, String pwd, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String salt = quizDao.getSalt(login);
        if (salt == null) {
            setWrongMessageToLoginJSP(req, resp);
        } else {
            String hashPwd = BCrypt.hashpw(pwd, salt);

            boolean equalsCredentialsWithSavedInDB = quizDao.isCredentialsEqual(login, hashPwd);
            if (equalsCredentialsWithSavedInDB) {
                setCredentialsToSession(login, hashPwd, req, resp);
            } else {
                setWrongMessageToLoginJSP(req, resp);
            }
        }
    }

    private void setWrongMessageToLoginJSP(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String wrongMessage = "<p>Your login or password are wrong. Try again.</p> <p>New user - press Sign up</p>";
        req.getSession().setAttribute("wrongMessage", wrongMessage);

        getLoginView(req, resp);
    }

    private void setCredentialsToSession(String login, String pwd, HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.getSession().setAttribute("login", login);
        req.getSession().setAttribute("pwd", pwd);

        resp.sendRedirect("/quiz");
    }
}
