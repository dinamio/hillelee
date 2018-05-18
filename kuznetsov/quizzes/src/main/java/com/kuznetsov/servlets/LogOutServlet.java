package servlets;


import enteties.Credentials;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {

    private Credentials credentials = new Credentials();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        session.removeAttribute("username");
        session.removeAttribute("password");
        session.invalidate();

        credentials.setPwd(null);
        credentials.setLogin(null);

        resp.sendRedirect("/");
    }
}
