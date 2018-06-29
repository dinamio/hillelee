package ui.Account;

import hibernate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CreateAccountServlet extends HttpServlet {
    @Autowired
    UserService userService;

    @Autowired
    hibernate.service.ServiceUser userHibService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("Registration.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String login,password;
        login=req.getParameter("uname");
        password=req.getParameter("psw");

        if(session.getAttribute("login")==null){
            if(login!=null && password!=null){
                User user= new User(login,password);

                boolean isCreateAcc = userService.addAccount(user); // if account has added
                if (isCreateAcc){ session.setAttribute("login", login);
                    resp.sendRedirect("/quizlist");
                }
            }
            else req.getRequestDispatcher("Registration.jsp").forward(req,resp);
        }
    }
}