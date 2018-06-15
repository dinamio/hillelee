package ui;

import entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.BookService;

import java.security.Principal;

/**
 * Created by eugen on 5/25/18.
 */
@Controller
//@ResponseBody
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public ModelAndView getBooks(Model model, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("books");
        modelAndView.addObject("books", bookService.getBooks());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{book_id}")
    public Book getBook(@PathVariable("book_id") Integer id) {
        Book result = bookService.getBooks().stream().filter(book -> book.getId().equals(id)).findFirst().get();
        return result;
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public String addBook(@ModelAttribute("bookToAdd") Book book) {
        bookService.addBook(book);
        return "redirect:/book";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable("id") Integer id) {
        bookService.deleteBook(id);
        return "OK";
    }
}
