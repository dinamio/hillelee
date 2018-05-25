package ui;

import entity.Book;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import service.BookService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by eugen on 4/13/18.
 */
public class BookServlet extends HttpServlet {

    Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    BookService bookService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("<h1>Библиотека</h1>");
        req.setAttribute("books", bookService.getBooks());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages//books.jsp");
        requestDispatcher.include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        bookService.addBook(new Book(title,author));
        resp.sendRedirect("/book");
    }
}
