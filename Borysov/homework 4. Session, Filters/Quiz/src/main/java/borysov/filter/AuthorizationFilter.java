package borysov.filter;

import borysov.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationFilter implements Filter {

    private static final Logger LOG = Logger.getLogger(AuthorizationFilter.class);

    private String encoding;


    public void init(FilterConfig fConfig) throws ServletException {
        LOG.debug("AuthorizationFilter");
    }


    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        LOG.debug("Filter starts AuthorizationFilter");

        HttpServletRequest tempRequest = (HttpServletRequest) request;
        HttpServletResponse tempResponse = (HttpServletResponse) response;

        User user = (User) tempRequest.getSession().getAttribute("currentUser");
        if (user == null) {
            LOG.debug("attempt to achieve inaccessible page");
            tempResponse.sendRedirect("/errorPage.jsp");
        }
        chain.doFilter(request, response);
    }

    public void destroy() {
        LOG.debug("Filter AuthorizationFilter destruction");
    }


}
