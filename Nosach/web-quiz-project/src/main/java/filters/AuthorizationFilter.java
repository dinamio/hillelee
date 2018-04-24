package filters;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.FileReader;
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


        boolean isAuthorized = checkAuthorizationFromFile(req);


        if(req.getRequestURI().matches(".*(css|jpg|png|gif|js].*)")){
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
        String pass  = (String)session.getAttribute("pass");

        if (login == null || pass == null) return false;

        try (BufferedReader fileReader = new BufferedReader(
                                            new FileReader(request.getServletContext().
                                                    getRealPath("/resources/properties/users.properties")))) {

            String line;
            while ((line = fileReader.readLine()) != null) {

                String [] arr = line.split("#");
                if(arr[0].equals(login) && arr[1].equals(pass)) return true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
