package by.nagula.controller;

import by.nagula.service.LikeByPostServiceImpl;
import by.nagula.service.PostServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(path = "/home")
public class ListPostController {
    private final PostServiceImpl postService;

    public ListPostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @GetMapping
    public ModelAndView getPagePosts(ModelAndView modelAndView){
        modelAndView.addObject("postList", postService.showPosts());
        modelAndView.setViewName("home");
        return modelAndView;
    }

}
