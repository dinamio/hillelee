package ui.usersevlets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import service.UserService;
import ui.usersevlets.service.Service;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/authentication")
public class AuthenticationServlet extends HttpServlet {
    private static final String LOGIN_PAGE = "/login.jsp";
    @Autowired
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String login = req.getParameter(Service.PARAM_NAME_LOGIN);
        String password = req.getParameter(Service.PARAM_NAME_PASSWORD);

        if (!userService.isUserAccountDataMatch(login, password)) {
            Service.forwardWithErrorMessage(req, resp, LOGIN_PAGE, Service.ERROR_LOGIN_PASS_MESSAGE);
        }

        session.setAttribute("userID", session.getId());
        session.setAttribute("login", login);
        resp.sendRedirect("/quiz");
    }
}
