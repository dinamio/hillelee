package filters;


import entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class AuthorizationFilter implements Filter{

    private static final Logger logger = Logger.getLogger(AuthorizationFilter.class);

    @Autowired
    UserService us;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, filterConfig.getServletContext());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(true);
        servletRequest.setCharacterEncoding("UTF-8");

        logger.info("Request URL: "+ req.getRequestURL());

        boolean isAuthorized = checkAuthorizationFromFile(req);

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

        servletResponse.setContentType("text/html; charset=utf8");
    }

    @Override
    public void destroy() { }

    private boolean checkAuthorizationFromFile (HttpServletRequest request){

        HttpSession session = request.getSession();
        String login = (String)session.getAttribute("login");
        String pass = (String)session.getAttribute("pass");
        String authorized  = (String)session.getAttribute("authorized");

        if (login == null) return false;

        logger.info("Checking authorization for login: "+login);

        if(Boolean.parseBoolean(authorized) == true) {

            logger.info("User: "+login+" already have registered session");
            return true;
        }

        User user = us.getUser(login);

        if (user ==null){
                return false;
            }

        PasswordEncoder encoder= new BCryptPasswordEncoder();
        if (encoder.matches(pass, user.getPassword())) {
                logger.info("User "+login+" found in db and authorized ");
                request.getSession().setAttribute("authorized", "true");
                return true;
            }

        logger.info("Wrong password for user "+login);
        return false;
    }
}
