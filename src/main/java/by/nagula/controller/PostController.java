package by.nagula.controller;

import by.nagula.dto.CommentDto;
import by.nagula.entity.Comment;
import by.nagula.entity.User;
import by.nagula.service.CommentServiceImpl;
import by.nagula.service.PostServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;


@Controller
@RequestMapping(path = "/home")
public class PostController {
    private final PostServiceImpl postService;
    private final CommentServiceImpl commentService;

    public PostController(PostServiceImpl postService, CommentServiceImpl commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    @GetMapping(path = "/post/{id}")
    public ModelAndView getPost(@PathVariable int id, ModelAndView modelAndView){
        modelAndView.addObject("comment", new CommentDto());
        modelAndView.addObject("commentList", commentService.showComments(id));
        modelAndView.addObject("post", postService.showById(id));
        modelAndView.setViewName("post");
        return modelAndView;
    }

    @PostMapping(path = "/post/")
    public ModelAndView addLikes(@ModelAttribute("comment") CommentDto commentDto, ModelAndView modelAndView, HttpSession session){
        Comment comment = new Comment();
        User user = (User) session.getAttribute("user");
        comment.setUser(user.getId());
        comment.setDate(Date.valueOf(LocalDate.now()));
        comment.setText(commentDto.getText());
        System.out.println(comment);
        commentService.addComment(comment);
        modelAndView.setViewName("post");
        return modelAndView;
    }
}
