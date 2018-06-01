package controllers;

import dao.impl.QuizDaoImpl;
import enteties.SubjectQuiz;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/")

public class LoginController {

    @Autowired
    private QuizDaoImpl quizDao;

    @RequestMapping(method = GET, value = "")
    public void getLogin(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;

        RequestDispatcher loginDispatcher = req.getRequestDispatcher("/view/login.jsp");
        if (req.getSession().getAttribute("wrongMessage") == null) {
            req.getSession().setAttribute("wrongMessage", "");
        }
        loginDispatcher.include(servletRequest, servletResponse);
    }


    @RequestMapping(method = POST, value = "")
        public void postLogin (@ModelAttribute("subjectQuiz") SubjectQuiz subjectQuiz, ServletRequest servletRequest, ServletResponse servletResponse) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String buttonType = subjectQuiz.getSubmit();
        String login = subjectQuiz.getLogin();
        String pwd = subjectQuiz.getPwd();

        if (buttonType.equals("Sign up")) {
            signUp(login, pwd, req, resp);
        }
        if (buttonType.equals("Sign in")) {
            signIn(login, pwd, req, resp);
        }
    }

    private void signUp(String login, String pwd, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        boolean userExist = quizDao.isUserExistInDB(login);
        if (!userExist) {
            String salt = BCrypt.gensalt();
            String hashPwd = BCrypt.hashpw(pwd, salt);
            quizDao.saveCredentials(login, hashPwd, salt);
            login(login, hashPwd, req, resp);
        } else {
            String wrongMessage = "<p>Username already exist</p>";
            req.getSession().setAttribute("wrongMessage", wrongMessage);
            getLogin(req, resp);
        }
    }

    private void signIn(String login, String pwd, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String salt = quizDao.getSalt(login);
        if (salt == null) setWrongMessage(req, resp);

        String hashPwd = BCrypt.hashpw(pwd, salt);

        boolean credentialsCons = quizDao.isCredentialsCons(login, hashPwd);
        if (credentialsCons) {
            login(login, hashPwd, req, resp);
        } else {
            setWrongMessage(req, resp);
        }
    }

    private void setWrongMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String wrongMessage = "<p>Your login or password are wrong. Try again.</p> <p>New user - press Sign up</p>";
        req.getSession().setAttribute("wrongMessage", wrongMessage);
        getLogin(req, resp);
    }

    private void login(String login, String pwd, HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.getSession().setAttribute("login", login);
        req.getSession().setAttribute("pwd", pwd);

        resp.sendRedirect("/quiz");
    }
}
