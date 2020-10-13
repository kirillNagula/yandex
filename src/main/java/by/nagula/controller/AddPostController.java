package by.nagula.controller;

import by.nagula.dto.PostDto;
import by.nagula.entity.Post;
import by.nagula.entity.User;
import by.nagula.service.PostServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(path = "/home")
public class AddPostController {
    private final PostServiceImpl postService;

    public AddPostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @GetMapping(path = "/add")
    public ModelAndView getAddPage(ModelAndView modelAndView){
        modelAndView.addObject("addPost", new PostDto());
        modelAndView.setViewName("add");
        return modelAndView;
    }

    @PostMapping(path = "/add")
    public ModelAndView addInPosts(@Valid @ModelAttribute("addPost") PostDto postDto, BindingResult bindingResult, ModelAndView modelAndView, HttpSession session){
        if (!bindingResult.hasErrors()){
            User user = (User)session.getAttribute("user");
            postService.createPost(postDto, user);
        }
        modelAndView.setViewName("redirect:/home");
        return modelAndView;
    }
}
