package by.nagula.controller;

import by.nagula.dto.CommentDto;
import by.nagula.entity.Comment;
import by.nagula.entity.Like;
import by.nagula.entity.User;
import by.nagula.service.CommentServiceImpl;
import by.nagula.service.LikeByPostServiceImpl;
import by.nagula.service.PostServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;


@Controller
@RequestMapping(path = "/home")
public class OnePostController {
    private final PostServiceImpl postService;
    private final CommentServiceImpl commentService;
    private final LikeByPostServiceImpl likeByPostService;

    public OnePostController(PostServiceImpl postService, CommentServiceImpl commentService, LikeByPostServiceImpl likeByPostService) {
        this.postService = postService;
        this.commentService = commentService;
        this.likeByPostService = likeByPostService;
    }

    @GetMapping(path = "/post/{id}")
    public ModelAndView getPost(@PathVariable int id, ModelAndView modelAndView){
        modelAndView.addObject("numberLikes", likeByPostService.getNumberOfLike(id));
        modelAndView.addObject("comment", new CommentDto());
        modelAndView.addObject("commentList", commentService.showComments(id));
        modelAndView.addObject("post", postService.showById(id));
        modelAndView.setViewName("post");
        return modelAndView;
    }

    @PostMapping(path = "/post/{id}")
    public ModelAndView addComment(@ModelAttribute("comment") CommentDto commentDto, @PathVariable int id, ModelAndView modelAndView,  HttpSession session){
        Comment comment = new Comment();
        User user = (User) session.getAttribute("user");
        comment.setIdUser(user.getId());
        comment.setDate(Date.valueOf(LocalDate.now()));
        comment.setText(commentDto.getText());
        comment.setIdPost(id);
        System.out.println(comment);
        commentService.addComment(comment);
        return getPost(id, modelAndView);
    }

    @PostMapping(path = "/post/like/{id}")
    public ModelAndView addLike(@PathVariable int id, ModelAndView modelAndView, HttpSession session){
        Like like = new Like();
        User user = (User) session.getAttribute("user");
        like.setUserId(user.getId());
        like.setPostId(id);
        likeByPostService.addLike(like);
        return getPost(id, modelAndView);
    }
}
