package filters;

import dao.impl.QuizDaoImpl;
import enteties.Credentials;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebFilter("/quiz")
public class LoginFilter implements Filter {
    private Credentials credentials = new Credentials();
    private QuizDaoImpl quizDao;

    @Override
    public void init(FilterConfig filterConfig) {
        quizDao = new QuizDaoImpl();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();

        String sessionLogin = (String) session.getAttribute("login");
        String sessionPwd = (String) session.getAttribute("pwd");
        Map<String, String> credentialsFromBD = new HashMap<>(quizDao.getCredentials());
        boolean trueUser = credentials.checkCredentials(credentialsFromBD, sessionLogin, sessionPwd);

        if (sessionLogin != null && trueUser) {
            filterChain.doFilter(servletRequest, servletResponse);

        } else {
            String buttonType = (String) session.getAttribute("buttonType");

            if (buttonType != null && buttonType.equals("Sign up")) {
                quizDao.saveCredentials(sessionLogin, sessionPwd);
                filterChain.doFilter(servletRequest, servletResponse);

            } else {
                resp.sendRedirect("/");
            }
        }
    }

    @Override
    public void destroy() {

    }
}

