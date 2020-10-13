package by.nagula.dao;

import by.nagula.dto.PostDto;
import by.nagula.entity.Post;
import by.nagula.entity.User;

import java.util.List;

public interface PostDao {
    void createPost(PostDto post, User user);
    List<Post> showAll();
    Post showById(long id);
    void deletePost(long id);
    boolean containsById(long id);
}
