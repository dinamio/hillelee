package controller;

import dao.ServerDao;
import model.Server;
import org.jboss.logging.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * Created by eugen on 11/21/17.
 */
@Controller
@RequestMapping("server")
public class ServerController {

    @Autowired
    private ServerDao serverDao;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "", method = RequestMethod.GET)
    //@GetMapping("get")
    public String index(Locale locale,Model model) {
        System.out.println("Locale: " + locale);
        messageSource.getMessage("servers.title",null,locale);
        model.addAttribute("name", "Ivan");
        model.addAttribute("servers",serverDao.findAll());
        return "index";
    }

    @RequestMapping(value = "/{server_id}", method = RequestMethod.GET)
    public ModelAndView getServer(@PathVariable("server_id") Integer id) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("server");
        maw.addObject("server", serverDao.findById(id));
        return maw;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddServerPage(Model model) {
        model.addAttribute("server", new Server());
        return "addServer";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addServer(@ModelAttribute @Valid Server server, BindingResult result) {
        if (result.hasErrors()) {
            return "addServer";
        }
        serverDao.save(server);
        return "redirect:/server/";
    }


}
