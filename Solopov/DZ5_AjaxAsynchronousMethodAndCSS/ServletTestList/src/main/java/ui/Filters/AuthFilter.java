package ui.Filters;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;




    public class AuthFilter implements Filter {
        private FilterConfig filterConfig;

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            this.filterConfig = filterConfig;
        }

        @Override
        public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) resp;
            HttpSession session =             request.getSession();
            /*request.getSession(false);*/

            String loginURL = request.getContextPath() + "/auth";
            String registrURL = request.getContextPath() + "/reg";

            boolean loggedIn = session != null && session.getAttribute("login") != null;
            boolean loginRequest = request.getRequestURI().equals(loginURL) || request.getRequestURI().equals(loginURL/* + ".html"*/);
            boolean registrRequest = request.getRequestURI().equals(registrURL) || request.getRequestURI().equals(registrURL/* + ".html"*/);

            if(loggedIn || loginRequest || registrRequest) {
                chain.doFilter(req, resp);
            }
            else {
                response.sendRedirect("/auth");
            }



//            response.sendRedirect("/Authorization.jsp");
        }

        @Override
        public void destroy() {
            this.filterConfig = null;
        }
    }
