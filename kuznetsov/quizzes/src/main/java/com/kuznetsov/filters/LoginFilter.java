package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter initialize");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String login = servletRequest.getParameter("login");

        if (login != null) {
            System.out.println("login -> " + login);
        RequestDispatcher logoutButton = servletRequest.getRequestDispatcher("logOutButton.jsp");
        logoutButton.include(servletRequest, servletResponse);
        } else {
            System.out.println("in equals");
            RequestDispatcher loginDispatcher = servletRequest.getRequestDispatcher("/login.jsp");
            loginDispatcher.include(servletRequest, servletResponse);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
