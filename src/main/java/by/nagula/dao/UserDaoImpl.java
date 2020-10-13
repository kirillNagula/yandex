package by.nagula.dao;

import by.nagula.entity.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDaoImpl implements UserDao {
    private final Connection connection;
    private static final String CREATE_USER = "INSERT users (name, login, password) VALUES (?,?,?)";
    private static final String SHOW_USER = "SELECT * FROM users WHERE login = ?";

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createUser(User user) {
        try {
            PreparedStatement st = connection.prepareStatement(CREATE_USER);
            st.setString(1, user.getName());
            st.setString(2, user.getLogin());
            st.setString(3, user.getPassword());
            st.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public User showUser(String login){
        User user = null;
        try {
            PreparedStatement st = connection.prepareStatement(SHOW_USER);
            st.setString(1, login);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()){
               user = new User(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getString("login"), resultSet.getString("password"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean containsById(long id) {
        return false;
    }

    @Override
    public boolean containsByLogin(String login) {
        return showUser(login) != null;
    }
}
