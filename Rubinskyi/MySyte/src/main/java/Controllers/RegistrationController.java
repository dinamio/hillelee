package Controllers;

import Entities.Pages;
import Entities.RegistrationBean;
import Services.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputLogin = req.getParameter("login");
        String inputPassword = req.getParameter("password");
        System.out.println("RegistrationController.Registration here: " + inputLogin + " " + inputPassword);

        if (RegistrationService.checkLoginIsUntaken(inputLogin)) {
            RegistrationService.getListRegistration().add(new RegistrationBean(inputLogin, inputPassword));
            System.out.println("RegistrationController.FirstLoginAndPassword " + RegistrationService.getListRegistration().get(0));
            System.out.println("EQUALS: " + new RegistrationBean("aa", "aa")
                    .equals(new RegistrationBean("aa", "aa")));

            req.getRequestDispatcher(String.valueOf(Pages.AUTHORIZATION_PAGE)).include(req, resp);
        } else {
            resp.sendRedirect(Pages.ERROR_PAGE.getPage());
        }
    }
}
