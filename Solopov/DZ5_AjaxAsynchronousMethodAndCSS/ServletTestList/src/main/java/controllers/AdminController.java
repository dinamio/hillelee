package controllers;

import dao.UserDAOReal;
import model.User;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("admin")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AdminController {
    private static Logger log = Logger.getLogger(AdminController.class.getName());

    @Autowired
    UserDAOReal userDAO;

    @RequestMapping(method = GET, value = "acclist")
    public String fillQuestionList(Model model) {
        model.addAttribute("list", userDAO.findAll());
        model.addAttribute("roles", User.Role.values());
        return "accountlist";
    }
    @PreAuthorize("hasAnyAuthority('admin','superadmin')")
    @RequestMapping(method = POST, value = "changerole", produces = "application/json")
    public ResponseEntity<String> changeRole(@RequestBody String jsonData) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = mapper.readValue(jsonData, HashMap.class);
        String role = map.get("role");
        String id = map.get("id");
        User user = userDAO.findById(Integer.valueOf(id));
        user.setRole(role);
        userDAO.update(user);
        String succesLine = "Role " + role + " of user by id " + id + " " + user.getLogin() + "  was successfully installed!";
        return new ResponseEntity<String>("{\"msg\":\"" + succesLine + "\"}", headers, HttpStatus.OK);
    }
}