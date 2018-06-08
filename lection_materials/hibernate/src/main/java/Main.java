import config.HibernateUtil;
import service.BookService;
import service.BookStoreService;

public class Main {

    public static void main(String[] args) {
        BookStoreService bookStoreService = new BookStoreService();
        BookService bookService = new BookService();
        //System.out.println(bookService.getBooksByName("Java 8 in action"));
        //System.out.println(bookService.getBooksByGenre("Comedy"));

        //bookStoreService.insertBook("12 chairs", 500, asList(new Author("Ilya", "Ilf"), new Author("Eugen","Petrov")), new Genre("Comedy"), new ISBN("3","3","bla","sixteen"));
        //bookStoreService.insertBook("", 201000, null, new Genre("Death"), new ISBN("6","8","13","19"));

        System.out.println(bookStoreService.getAuthorById(2));
        //System.out.println(bookService.getBooksByGenre("tragey"));
        HibernateUtil.getSessionFactory().close();
    }


}
