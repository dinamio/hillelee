/*
package Filters;

import Entities.Pages;
import Services.RegistrationService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebFilter("index.jsp")
public class NecessaryRegistrationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        String loginURL = request.getContextPath() + Pages.AUTHORIZATION_PAGE.getPage();
        String registrationURL = request.getContextPath() + Pages.REGISTRATION_PAGE.getPage();

        boolean loggedIn = session != null && session.getAttribute("login") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURL);
        boolean registrationRequest = request.getRequestURI().equals(registrationURL);

        if(loggedIn || loginRequest || registrationRequest) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else {
            response.sendRedirect(Pages.REGISTRATION_PAGE.getPage());
        }
    }

    @Override
    public void destroy() {

    }
}
*/
