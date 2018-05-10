package servlets;

import logging.Log;
import service.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Registration", urlPatterns = "/reg")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Log.writeInfo("Registration started...");
            String login = req.getParameter("login");
            String pass = req.getParameter("password");
            RegistrationService service = new RegistrationService();
            service.addNew(login, pass);
            Log.writeInfo("Registration finished.");
            resp.sendRedirect("login.jsp");
        } catch (Exception e){
            Log.writeError(e, "Registration failed.");
        }


    }
}
