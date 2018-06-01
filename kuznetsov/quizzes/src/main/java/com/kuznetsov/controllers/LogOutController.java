package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.POST;



@Controller
@RequestMapping(value = "/logout")
public class LogOutController {


    @RequestMapping(method = POST, value = "")
    public void logOut(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        session.removeAttribute("username");
        session.removeAttribute("pwd");
        session.invalidate();

        resp.sendRedirect("/");
    }
}
