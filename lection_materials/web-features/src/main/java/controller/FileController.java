package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by eugen on 11/26/17.
 */
@Controller("file")
public class FileController {

    @PostMapping
    public String uploadImage(@RequestParam(value = "file") MultipartFile file) {
        return "redirect:server/add";
    }
}
