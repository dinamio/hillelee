package com.nosach.quizproject.controllers;

import com.nosach.quizproject.entity.Role;
import com.nosach.quizproject.entity.User;
import com.nosach.quizproject.service.RoleService;
import com.nosach.quizproject.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UserController {

    Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    protected AuthenticationManager authenticationManager;

    @RequestMapping(method = GET, value = "register")
    public String getRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "register-page";
    }

    @RequestMapping(method = POST, value = "register")
    public String doRegistration(HttpServletRequest req, @Valid @ModelAttribute("user") User user, BindingResult bindingResult, @RequestParam("password") String password) {
        if(bindingResult.hasErrors()){
         return "register-page";
        }
        Role role = roleService.getRole("user");
        user.setRole(role);
        if(userService.addUser(user)){
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getLogin(), password);
            token.setDetails(new WebAuthenticationDetails(req));
            Authentication authenticatedUser = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
            req.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
            return "redirect:available";
        }
        else return "redirect:register";
    }

    @RequestMapping(method = GET, value = "/login")
    public String getLoginPage(){
        return "login-page";
    }
}
