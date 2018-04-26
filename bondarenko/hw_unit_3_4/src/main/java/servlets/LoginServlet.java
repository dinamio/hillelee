package servlets;

import command.Command;
import command.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stringCommand = req.getParameter("command");
        Command command = null;
        try {
            command = CommandFactory.create(stringCommand);
            command.execute(req);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
