package config;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by eugen on 5/18/18.
 */
@Configuration
@ComponentScan(basePackages = "dao,service")
public class BookConfiguration {

    @Bean
    BookDao getBookDao() {
        return new BookDaoImpl();
    }
}
