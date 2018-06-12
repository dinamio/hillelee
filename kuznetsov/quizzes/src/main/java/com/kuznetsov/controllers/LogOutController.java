package com.kuznetsov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class LogOutController {

    @RequestMapping(method = POST, value = "/logout")
    public String logOut(HttpSession session) {

        session.removeAttribute("username");
        session.removeAttribute("pwd");
        session.invalidate();

        return "redirect:/";
    }
}
