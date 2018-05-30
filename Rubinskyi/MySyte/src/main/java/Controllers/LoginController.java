package Controllers;

import Entities.Pages;
import Services.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        System.out.println("RegistrationService.Login and password: " + login + " " + password);

        if (RegistrationService.checkLoginAndPassword(login, password)) {
            session.setAttribute("login", login);
            session.setAttribute("password", password);

            req.getRequestDispatcher(String.valueOf(Pages.FIST_PAGE)).forward(req, resp);
        } else {
            resp.sendRedirect(Pages.ERROR_PAGE.getPage());
        }
    }
}
