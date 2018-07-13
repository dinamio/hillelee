package config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.sql.DataSource;

@Configuration
@ComponentScan({"controllers","model","dao","service"})
public class AppConfiguration {

    @Bean
    LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setPackagesToScan(new String[]{"model"});
        sessionFactory.setDataSource(datasource());
        return sessionFactory;
    }

    @Bean
    JdbcTemplate jdbcTemplate(){return new JdbcTemplate(datasource());}

    @Bean
    public DataSource datasource(){
        BasicDataSource dataSource=new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/quizzes");
        dataSource.setUsername("root");
        dataSource.setPassword("dbpass");
        return dataSource;
    }

    @Bean
    HibernateTransactionManager transactionManager(@Autowired SessionFactory sessionFactory){
        HibernateTransactionManager manager= new HibernateTransactionManager();
        manager.setDataSource(datasource());
        manager.setSessionFactory(sessionFactory);
        return manager;
    }


}
