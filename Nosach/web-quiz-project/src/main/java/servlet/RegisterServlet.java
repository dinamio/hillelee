package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/view/register-page.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String pass = req.getParameter("pass");
        String email = req.getParameter("email");

        try (FileWriter fw = new FileWriter(getServletContext().getRealPath("/resources/properties/users.properties"), true)) {

            fw.write(login + "#" + pass + "#" + email + "\n");
            fw.flush();
        }

        req.getSession().setAttribute("login", login);
        req.getSession().setAttribute("pass", pass);
        resp.sendRedirect("/list");
        return;
    }
}

