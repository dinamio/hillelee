package filters;

import dao.impl.QuizDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
@WebFilter("/quiz")
public class LoginFilter implements Filter {

    @Autowired
    private QuizDaoImpl quizDao;

    @Override
    public void init(FilterConfig filterConfig) {

            SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                    filterConfig.getServletContext());
        }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();

        String sessionLogin = (String) session.getAttribute("login");
        String sessionPwd = (String) session.getAttribute("pwd");

        boolean trueUser = quizDao.isCredentialsCons(sessionLogin, sessionPwd);

        if (sessionLogin != null && trueUser) {
            filterChain.doFilter(servletRequest, servletResponse);

        } else {
            resp.sendRedirect("/");
        }
    }

    @Override
    public void destroy() {

    }
}

