package by.nagula.dao;

import by.nagula.entity.Comment;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {
    private final Connection connection;
    private static final String ADD_COMMENT = "INSERT comment (text, date, id_user, id_post) VALUES (?,?,?,?)";
    private static final String SHOW_BY_POST_ID = "SELECT * FROM comment WHERE id_post = ?";

    public CommentDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addComment(Comment comment) {
        try {
            PreparedStatement st = connection.prepareStatement(ADD_COMMENT);
            st.setString(1, comment.getText());
            st.setDate(2, comment.getDate());
            st.setLong(3, comment.getId());
            st.setLong(4, comment.getIdPost());
            st.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Comment> showByPostId(long postID) {
        List<Comment> commentList = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(SHOW_BY_POST_ID);
            st.setLong(1, postID);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                commentList.add(new Comment(rs.getString("text"), rs.getLong("id_user"), rs.getDate("date"),  rs.getLong("id_post")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return commentList;
    }
}
