package by.nagula.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/home")
public class PostController {

    @GetMapping(path = "/post")
    public ModelAndView getPost(ModelAndView modelAndView){
        modelAndView.setViewName("post");
        return modelAndView;
    }
}
