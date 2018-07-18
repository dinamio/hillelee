package com.kuznetsov.controllers;

import com.kuznetsov.dao.impl.daoServices.UserDao;
import com.kuznetsov.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller()
public class LoginController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping(value = "/login")
    public String getLogin(){
        return "login";
    }

    @RequestMapping(method = GET, value = "/signin")
    public String getSignUpPage(Model model) {

        model.addAttribute("user", new Users());
        return "signin";
    }

    @RequestMapping(method = POST, value = "/signin")
     String signUpButtonAction(@ModelAttribute @Valid Users users, BindingResult bindingResult) {

        if(userDao.getUsersByLogin(users.getLogin()) != null){
            bindingResult.rejectValue("login", "error.login", "login is busy");
            return "signin";
        }
        if (bindingResult.hasErrors()) {
            return "signin";
        }

        String currentPwd = users.getPwd();
        Pattern pattern = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{4,20})");
        Matcher matcher = pattern.matcher(currentPwd);

        if (matcher.matches()){
            String pwd = passwordEncoder.encode(currentPwd);
            users.setPwd(pwd);
            /*userDao.saveUser(user);*/
            return "redirect:/login";
        } else bindingResult.rejectValue("pwd", "error.pwd", "Password must consist at least a one digit, a one uppercase and a one lowercase letters");
        return "signin";
    }
}