package filter;

import entity.Pages;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/index.jsp") /* * */
public class RedirectToRegistrationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        String registrationURL = request.getContextPath() + "/Registration.jsp";
        String authorizationURL = request.getContextPath() + "/Authorization.jsp";
        String indexUrl = request.getRequestURI();
        //System.out.println("FILTER_REQ: " + " registration: " + registrationURL + " authorization: " + authorizationURL + " index: " + indexUrl);


        boolean isAuthorized = session != null && session.getAttribute("login") != null;
        //System.out.println("ITERATION");
        //System.out.println("We are here: " + request.getRequestURI());
        boolean onRegistrationRequest = request.getRequestURI().equals(registrationURL);
        //System.out.println("FILTER.IS_AUTHORIZED: " + isAuthorized);
        //System.out.println("FILTER.ON REGISTRATION : " + onRegistrationRequest);
        boolean onAuthorizationRequest = request.getRequestURI().equals(authorizationURL);
       // System.out.println("FILTER.ON AUTHORIZATION: " + onAuthorizationRequest);

        if (isAuthorized || onAuthorizationRequest || onRegistrationRequest) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect(Pages.REGISTRATION_PAGE.getPage());
        }
    }

    @Override
    public void destroy() {
    }
}
