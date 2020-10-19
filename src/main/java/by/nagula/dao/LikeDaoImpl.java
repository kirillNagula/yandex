package by.nagula.dao;

import by.nagula.entity.Like;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class LikeDaoImpl implements LikeDao {
    private final Connection connection;
    private static final String ADD = "INSERT like_post (id_post, id_user) VALUES (?,?)";
    private static final String SHOW_BY_POST = "SELECT * FROM like_post WHERE id_post = ?";
    private static final String SHOW_BY_POST_USER = "SELECT * FROM like_post WHERE id_post = ? AND id_user = ?";

    public LikeDaoImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void addLike(Like like) {
        try {
            if (!checkLikeByPost(like.getUserId(),like.getPostId())){
                PreparedStatement statement = connection.prepareStatement(ADD);
                statement.setLong(1, like.getPostId());
                statement.setLong(2, like.getUserId());
                statement.execute();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean checkLikeByPost(long userId, long postId) {
        try {
            PreparedStatement statement = connection.prepareStatement(SHOW_BY_POST_USER);
            statement.setLong(1, postId);
            statement.setLong(2, userId);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public int numberOfLikes(long postId) {
        int likeNumber = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(SHOW_BY_POST);
            statement.setLong(1, postId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                likeNumber++;
            }
        } catch (SQLException throwables) {
            return likeNumber;
        }
        return likeNumber;
    }
}
