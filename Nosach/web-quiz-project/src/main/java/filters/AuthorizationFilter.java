package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



public class AuthorizationFilter implements Filter{


    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(true);
        servletRequest.setCharacterEncoding("UTF-8");


        boolean isAuthorized = true;

        if (session.getAttribute("login") == null){
            isAuthorized = false;
        }

        if(req.getRequestURI().matches(".*(css|jpg|png|gif|js].*)")){
            filterChain.doFilter(req, resp);
            return;
        }

        if (req.getRequestURI().equals("/")){
            resp.sendRedirect("/login");
            return;
        }

        if (!isAuthorized && !req.getRequestURI().equals("/login")){
            resp.sendError(403);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);

        servletResponse.setContentType("text/html; charset=utf8");
    }

    @Override
    public void destroy() { }
}
