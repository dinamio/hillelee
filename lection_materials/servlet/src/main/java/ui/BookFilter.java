package ui;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by eugen on 4/20/18.
 */
public class BookFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter initialized");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Doing filtration....");
        servletResponse.setContentType("text/html; charset=utf-8");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Back from servlet....");
    }

    public void destroy() {

    }
}
