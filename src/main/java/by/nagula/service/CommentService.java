package by.nagula.service;

import by.nagula.entity.Comment;

import java.util.List;

public interface CommentService {
    void addComment(Comment comment);
    List<Comment> showComments(long postId);
}
