package ui.Account;

import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginServlet extends HttpServlet {
        private static Logger log = Logger.getLogger(LoginServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String login,password;
        login=req.getParameter("uname");
        password=req.getParameter("psw");
        log.info(login+" "+password);

        if(login!=null || password!=null){
            if(new UserService().authorizate(login,password)){
                 session.setAttribute("login",login);
                 resp.sendRedirect("/quizlist");
            }
            else req.getRequestDispatcher("Authorization.jsp").forward(req,resp);
        }
        else req.getRequestDispatcher("Authorization.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
