package config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.sql.DataSource;

/**
 * Created by eugen on 5/18/18.
 */
@Configuration
@ComponentScan(basePackages = "dao,service,ui")

public class BookConfiguration {


    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/Books");
        dataSource.setUsername("root");
        dataSource.setPassword("qwerty");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("entity");
        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager tm = new HibernateTransactionManager();
        tm.setSessionFactory(sessionFactory().getObject());
        return tm;
    }

}
