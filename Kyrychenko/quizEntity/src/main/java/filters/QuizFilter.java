package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class QuizFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if (session.getAttribute("userID") == null) {
            if ("login".equals(action) || "registration".equals(action)) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Authentication required");
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }




}

