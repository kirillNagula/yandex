package by.nagula.dao;

import by.nagula.entity.Post;

import java.util.List;

public interface PostDao {
    void createPost(Post post);
    List<Post> showAll();
    void deletePost(Post post);
    void updatePost(Post post);
    boolean containsById(long id);
}
