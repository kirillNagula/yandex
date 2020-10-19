package by.nagula.dao;

import by.nagula.entity.Like;

public interface LikeDao {
    void addLike(Like like);
    boolean checkLikeByPost(long userId, long postId);
    int numberOfLikes(long postId);
}
