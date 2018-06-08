package filters;



import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorizationFilter implements Filter{

    private static final Logger logger = Logger.getLogger(AuthorizationFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(true);

        logger.info("Request URL: "+ req.getRequestURL());

        boolean isAuthorized = false;

        if (session.getAttribute("authorized") != null){
            isAuthorized = true;
        }


        if(req.getRequestURI().matches(".*(css|jpg|js|ico|png|gif.*)")){
            filterChain.doFilter(req, resp);
            return;
        }

        if (req.getRequestURI().equals("/")){
            resp.sendRedirect("/login");
            return;
        }

        if (req.getRequestURI().equals("/register")){
            filterChain.doFilter(req, resp);
            return;
        }

        if (!isAuthorized && !req.getRequestURI().equals("/login")){
            resp.sendError(403);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() { }
}
