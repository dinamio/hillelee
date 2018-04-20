package ui;

import db.Book;
import service.BookAdder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class BookServlet extends HttpServlet {
    private BookAdder bookAdder;

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String author = req.getParameter("author");
        String bookName = req.getParameter("name");

        if (bookAdder == null) {
            bookAdder = new BookAdder();
        }

        bookAdder.addBook(new Book(author, bookName));
    }


    // getting page with adding a book form
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/books.jsp");
        dispatcher.forward(req, resp);
    }
}
