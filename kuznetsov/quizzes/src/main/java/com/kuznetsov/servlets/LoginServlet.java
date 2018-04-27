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

    private Credentials credentials = Credentials.getSingleton();
    private String login;
    private String pwd;
    private String message;
    private String buttonType;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher loginDispatcher = req.getRequestDispatcher("/login.jsp");

        loginDispatcher.include(req, resp);

        if (message.equals("wrong")) {
            resp.getWriter().print("<h2>Your login or password are wrong. Try again. New user - press Sign up</h2>");
            message = null;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        buttonType = req.getParameter("submit");
        login = req.getParameter("login");
        pwd = req.getParameter("pwd");

        if (buttonType.equals("Sign up") && !credentials.getSavedCredentials().containsKey(login)) {

            credentials.setSavedCredentials(login, pwd);
            login(req, resp);

        } else {

            if (checkCredentials(login, pwd)) {
                login(req, resp);

            } else {
                message = "wrong";
                doGet(req, resp);
            }
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.getSession().setAttribute("login", login);
        req.getSession().setAttribute("pwd", pwd);
        req.getSession().setAttribute("buttonType", buttonType);
        credentials.setLogin(login);
        credentials.setPwd(pwd);

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
