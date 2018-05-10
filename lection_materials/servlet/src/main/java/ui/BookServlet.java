package ui;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by eugen on 4/13/18.
 */
public class BookServlet extends HttpServlet {

    public int value = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("<h1>Библиотека</h1>");
        req.setAttribute("book", "War and piece");
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println("Cookie : " + cookie.getName() + " " + cookie.getValue());
        }
        System.out.println();
        Cookie cookie = new Cookie("my_cookie" + value++, "value");
        cookie.setMaxAge(10);
        resp.addCookie(cookie);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/books.jsp");
        requestDispatcher.include(req, resp);
        //super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("We are here");
    }
}
