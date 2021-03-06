package com.kuznetsov.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.util.logging.Logger;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
                http
                .csrf().disable()
                .formLogin().loginPage("/login")
                .usernameParameter("userid")
                .passwordParameter("passwd")

                .successHandler((req,res,auth)->{
                    for (GrantedAuthority authority : auth.getAuthorities()) {
                        logger.info(authority.getAuthority());
                    }
                    logger.info(auth.getName());
                    res.sendRedirect("/quiz");
                })

                .failureHandler((req,res,exp)->{
                    String errMsg;
                    if(exp.getClass().isAssignableFrom(BadCredentialsException.class)){
                        errMsg="Invalid username or password.";
                    }else{
                        errMsg = exp.getMessage();
                    }
                    req.getSession().setAttribute("message", errMsg);
                    res.sendRedirect("/login");
                })
                .and()
                .authorizeRequests().antMatchers("/login").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
    @Override
    public void configure(WebSecurity web){
        web.ignoring().antMatchers("/resources/**", "/signin");
    }
}
