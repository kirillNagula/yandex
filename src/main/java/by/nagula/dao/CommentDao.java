package by.nagula.dao;

import by.nagula.entity.Comment;

import java.util.List;

public interface CommentDao {
    void addComment(Comment comment);
    List<Comment> showByPostId(long postID);
}
