package controllers;

import dao.UserDAOReal;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.logging.Logger;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class AdditionalPagesController {
    private static Logger log = Logger.getLogger(AdminController.class.getName());
    @Autowired
    UserDAOReal daoReal;
    @RequestMapping(method = GET, value = "/welcomepage")
    String welcomepage(){
        return "welcomepage";
    }

}
