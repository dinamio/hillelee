package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/view/*")
public class JspFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();

        if (session.getAttribute("userID") == null && servletRequest.getRequestURI().endsWith(".jsp")) {
            servletResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Authentication required");
        } else {
            chain.doFilter(request, response);
        }

    }
}
