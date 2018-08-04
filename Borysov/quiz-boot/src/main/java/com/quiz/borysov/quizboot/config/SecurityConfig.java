package com.quiz.borysov.quizboot.config;

import com.quiz.borysov.quizboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);


    @Autowired
    DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        LOGGER.info(String.valueOf(auth));
        auth.
                jdbcAuthentication().dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder()).
                usersByUsernameQuery("select login,password,true from users where login=?").
                authoritiesByUsernameQuery("select login,role from users where login =?");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().
                formLogin().loginPage("/login").
                passwordParameter("password_field").
                usernameParameter("login_field").
                successForwardUrl("/mainPage").failureHandler((req, res, exp) -> {
            String errMsg;
            if (exp.getClass().isAssignableFrom(BadCredentialsException.class)) {
                errMsg = "Invalid username or password.";
            } else {
                errMsg = exp.getMessage();
            }
            req.getSession().setAttribute("message", errMsg);
            res.sendRedirect("/login");
        }).
                and().
                authorizeRequests().antMatchers("/login").permitAll().
                and().
                authorizeRequests().anyRequest().authenticated();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/register", "/index");
        web.ignoring().antMatchers("../webapp/css/**", "/src/main/webapp/css/assets/**", "/register", "/static/**");
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}