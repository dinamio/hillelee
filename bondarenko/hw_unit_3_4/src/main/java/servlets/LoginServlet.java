package servlets;

import command.Command;
import command.CommandFactory;
import logging.Log;
import logging.LoggerManager;

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
        Log.writeInfo("Specified command {%s}", stringCommand);
        Command command = null;
        try {
            command = CommandFactory.create(stringCommand);
            Log.writeInfo("Start execution of {%s} command", command);
            command.execute(req, resp);
            Log.writeInfo("Finish execution of {%s} command", command.toString());
        } catch (Exception e) {
            Log.writeError(e, "Unable to execute {%s} command", command);
        }
    }
}
