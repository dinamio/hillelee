package controller;

import dao.ServerDao;
import model.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by eugen on 11/21/17.
 */
@RestController
@RequestMapping("rest")
public class TestController {

    @Autowired
    ServerDao serverDao;

    @RequestMapping(value = "servers", method = RequestMethod.GET)
    public List<Server> getServers () {
        return serverDao.findAll();
    }
}
