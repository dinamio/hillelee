package servlets;

import enteties.Credentials;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class LoginServlet extends HttpServlet {

    private Credentials credentials = new Credentials();
    private String login;
    private String pwd;
    private String message;
    private String buttonType;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher loginDispatcher = req.getRequestDispatcher("/view/login.jsp");
        if ( req.getSession().getAttribute("wrongMessage") == null){
        req.getSession().setAttribute("wrongMessage", "");
        }
        loginDispatcher.include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        buttonType = req.getParameter("submit");
        login = req.getParameter("login");
        pwd = req.getParameter("pwd");
        credentials.setSavedCredentials(login, pwd);

        if (buttonType.equals("Sign up") && !credentials.getSavedCredentials().containsKey(login)) {


            login(req, resp);

        } else {

            if (checkCredentials(login, pwd)) {
                login(req, resp);

            } else {
                String wrongMessage = "<p>Your login or password are wrong. Try again.</p> <p>New user - press Sign up</p>";
                req.getSession().setAttribute("wrongMessage",wrongMessage);
                doGet(req, resp);
            }
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.getSession().setAttribute("login", login);
        req.getSession().setAttribute("pwd", pwd);
        req.getSession().setAttribute("buttonType", buttonType);
        /*credentials.setLogin(login);
        credentials.setPwd(pwd);*/

        resp.sendRedirect("/quiz");
    }

    private boolean checkCredentials(String login, String pwd) {
        boolean correctCredentials = false;

        try {
            correctCredentials = credentials.getSavedCredentials().get(login).equals(pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return correctCredentials;
    }
}
