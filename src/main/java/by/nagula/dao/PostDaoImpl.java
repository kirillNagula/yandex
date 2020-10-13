package by.nagula.dao;

import by.nagula.dto.PostDto;
import by.nagula.entity.Post;
import by.nagula.entity.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostDaoImpl implements PostDao {
    private final Connection connection;
    private static final String CREATE_POST = "INSERT post (title, description, text, like_id, user_id) VALUES (?,?,?,?,?)";
    private static final String SHOW_ALL = "SELECT * FROM post";
    private static final String SHOW_BY_ID = "SELECT * FROM post WHERE id = ?";
    private static final String DELETE = "DELETE * FROM post WHERE id = ?";
    private static final String SHOW_USER = "SELECT * FROM users WHERE id = ?";

    public PostDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createPost(PostDto post, User user) {
        try {
            PreparedStatement statement = connection.prepareStatement(CREATE_POST);
            statement.setString(1,post.getTitle());
            statement.setString(2,post.getDescription());
            statement.setString(3,post.getText());
            statement.setLong(4,0);
            statement.setLong(5, user.getId());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Post> showAll() {
        List<Post> posts = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(SHOW_ALL);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()){
                long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String text = resultSet.getString("text");
                long like_id = resultSet.getLong("like_id");
                long user_id = resultSet.getLong("user_id");
                posts.add(new Post(id,title, description, text, user_id, like_id));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return posts;
    }

    @Override
    public Post showById(long id) {
        Post post = null;
        try {
            PreparedStatement st = connection.prepareStatement(SHOW_BY_ID);
            st.setLong(1, id);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()){
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String text = resultSet.getString("text");
                long like_id = resultSet.getLong("like_id");
                long user_id = resultSet.getLong("user_id");
                post = new Post(id, title, description, text, user_id, like_id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return post;
    }


        @Override
    public void deletePost(long id) {
        try {
            PreparedStatement st = connection.prepareStatement(DELETE);
            st.setLong(1, id);
            st.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean containsById(long id) {
        try {
            PreparedStatement st = connection.prepareStatement(SHOW_BY_ID);
            st.setLong(1, id);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
