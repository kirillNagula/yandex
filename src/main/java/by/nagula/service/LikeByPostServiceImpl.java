package by.nagula.service;

import by.nagula.dao.LikeDaoImpl;
import by.nagula.entity.Like;
import org.springframework.stereotype.Service;

@Service
public class LikeByPostServiceImpl implements LikeByPostService {
    private final LikeDaoImpl likeDao;

    public LikeByPostServiceImpl(LikeDaoImpl likeDao) {
        this.likeDao = likeDao;
    }

    @Override
    public void addLike(Like like) {
        likeDao.addLike(like);
    }

    @Override
    public int getNumberOfLike(long postId) {
        return likeDao.numberOfLikes(postId);
    }
}
