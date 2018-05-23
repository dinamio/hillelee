package servlets;

import dao.impl.QuizDaoImpl;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class LoginServlet extends HttpServlet {

    @Autowired
    private QuizDaoImpl quizDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher loginDispatcher = req.getRequestDispatcher("/view/login.jsp");
        if (req.getSession().getAttribute("wrongMessage") == null) {
            req.getSession().setAttribute("wrongMessage", "");
        }
        loginDispatcher.include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String buttonType = req.getParameter("submit");
        String login = req.getParameter("login");
        String pwd = req.getParameter("pwd");


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
            doGet(req, resp);
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
        doGet(req, resp);
    }

    private void login(String login, String pwd, HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.getSession().setAttribute("login", login);
        req.getSession().setAttribute("pwd", pwd);

        resp.sendRedirect("/quiz");
    }
}
