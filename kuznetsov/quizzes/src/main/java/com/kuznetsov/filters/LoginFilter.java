package filters;

import enteties.Credentials;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter("/quiz")
public class LoginFilter implements Filter {
    private Credentials credentials = Credentials.getSingleton();

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();

        String sessionLogin = (String) session.getAttribute("login");
        String sessionPwd = (String) session.getAttribute("pwd");
        String savedLogin = credentials.getLogin();
        String savedPwd = credentials.getPwd();


        if (sessionLogin != null && sessionLogin.equals(savedLogin) && sessionPwd.equals(savedPwd)) {
            filterChain.doFilter(servletRequest, servletResponse);

        } else {
            String buttonType = (String) session.getAttribute("buttonType");

            if (buttonType != null && buttonType.equals("Sign up")) {
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

