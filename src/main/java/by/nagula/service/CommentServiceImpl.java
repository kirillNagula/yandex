package by.nagula.service;

import by.nagula.dao.CommentDaoImpl;
import by.nagula.entity.Comment;
import by.nagula.exception.EmptyListOfComment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentDaoImpl commentDao;

    public CommentServiceImpl(CommentDaoImpl commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public void addComment(Comment comment) {
        commentDao.addComment(comment);
    }

    @Override
    public List<Comment> showComments(long postId) {
        return commentDao.showByPostId(postId);
    }
}
