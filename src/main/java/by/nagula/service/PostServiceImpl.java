package by.nagula.service;

import by.nagula.dao.PostDaoImpl;
import by.nagula.dto.PostDto;
import by.nagula.entity.Post;
import by.nagula.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostDaoImpl postDao;

    public PostServiceImpl(PostDaoImpl postDao) {
        this.postDao = postDao;
    }

    @Override
    public void createPost(PostDto post, User user) {
        postDao.createPost(post, user);
    }

    @Override
    public List<Post> showPosts() {
        return postDao.showAll();
    }

    @Override
    public void deletePost(long id) {
        postDao.deletePost(id);
    }

    @Override
    public boolean containsPost(long id) {
        return postDao.containsById(id);
    }

    @Override
    public Post showById(long id) {
        return postDao.showById(id);
    }
}
