package by.nagula.service;

import by.nagula.entity.Like;

public interface LikeByPostService {
    void addLike(Like like);
    int getNumberOfLike(long postId);
}
