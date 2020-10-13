package by.nagula.service;

import by.nagula.dto.PostDto;
import by.nagula.entity.Post;
import by.nagula.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {
    void createPost(PostDto post, User user);
    List<Post> showPosts();
    void deletePost(long id);
    boolean containsPost(long id);
    Post showById(long id);
}
