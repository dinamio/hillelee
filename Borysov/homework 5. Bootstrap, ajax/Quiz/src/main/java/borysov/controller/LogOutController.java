package borysov.controller;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class LogOutController
 */
@WebServlet("/LogOut")
public class LogOutController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(LogOutController.class);


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        LOGGER.info("Log out");
        HttpSession httpSession = request.getSession(false);
        if (httpSession != null) {
            httpSession.invalidate();
        }

        response.sendRedirect("index.jsp");
    }

}
