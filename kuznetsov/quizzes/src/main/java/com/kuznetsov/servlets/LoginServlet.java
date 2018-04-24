package servlets;

import services.QuizServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class LoginServlet extends HttpServlet {
    private QuizServices services = new QuizServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher loginDispatcher = req.getRequestDispatcher("/login.jsp");

        loginDispatcher.include(req, resp);

        if (req.getSession().getAttribute("login").equals("wrong")){
            resp.getWriter().print("<h2>Your login or password are wrong. Try again. New user - press Sign up</h2>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String button = req.getParameter("submit");
        String login = req.getParameter("login");
        String pwd = req.getParameter("pwd");

        if (button.equals("Sign up")){

            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("pwd", pwd);

            services.getSavedCredentials().put(login, pwd);

            resp.sendRedirect("/quiz");

        } else {

            if (services.getSavedCredentials().get(login).equals(pwd)) {

                resp.sendRedirect("/quiz");

            } else {
                /*req.getSession().setAttribute("login", "wrong" );*/
                doGet(req, resp);
            }
        }
    }
}
