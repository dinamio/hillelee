package filters;

import services.QuizServices;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

@WebFilter("/login.jsp")
public class LoginFilter implements Filter {
    QuizServices services = new QuizServices();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("login filter init");
      }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String sign = req.getParameter("submit");
        System.out.println("button is " + sign);

        /*String login = (String) req.getSession().getAttribute("login");
        String pwd = (String) req.getSession().getAttribute("pwd");

        if (login != null && pwd != null) {

            if (services.getSavedCredentials().get(login).equals(pwd)) {
                System.out.println("login -> " + login + " " + "pwd -> " + pwd);
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                RequestDispatcher loginDispatcher = servletRequest.getRequestDispatcher("login.jsp");
                servletResponse.getWriter().print("<h2>Your login or password are wrong. Try again. New user - press Sign up</h2>");
                loginDispatcher.include(servletRequest, servletResponse);
            }


        }*/
    }
    @Override
    public void destroy() {

    }
}
