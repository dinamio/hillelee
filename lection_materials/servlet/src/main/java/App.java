import entity.Author;
import entity.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by eugen on 5/18/18.
 */
    public class App {

    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("/src/main/resources/application-context.xml");
        Book myBook = (Book) context.getBean("myBook");
        myBook.setName("new name");
        System.out.println(myBook);
        System.out.println(context.getBean("myBook"));

        Author author = context.getBean(Author.class);
        System.out.println(author);

    }
}
