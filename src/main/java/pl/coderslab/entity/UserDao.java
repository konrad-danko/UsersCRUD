package pl.coderslab.entity;

import pl.coderslab.utils.DbUtil;

import java.sql.*;

public class UserDao {
    private static final String CREATE_USER_QUERY = "INSERT INTO users (email, username, password) values (?,?,?)";
    private static final String READ_USER_QUERY = "SELECT * FROM users WHERE id=?";
    private static final String UPDATE_USER_QUERY = "UPDATE users SET email=?, username=?, password=? WHERE id=?";
    private static final String DELETE_USER_QUERY = "DELETE FROM users WHERE id=?";
    private static final String READ_ALL_USERS_QUERY = "SELECT * FROM users ORDER BY username, email, id";

    public static User createUser(User user) {
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement prepStat = conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            prepStat.setString(1, user.getEmail());
            prepStat.setString(2, user.getUserName());
            prepStat.setString(3, user.getPassword());
            prepStat.executeUpdate();
            ResultSet resSet = prepStat.getGeneratedKeys();
            if (resSet.next()) {
                user.setId(resSet.getLong(1));
            }
            return user;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static User readUser (int userId) {
        try (Connection conn = DbUtil.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(READ_USER_QUERY)) {
            prepStat.setLong(1, userId);
            ResultSet resSet = prepStat.executeQuery();
            if (resSet.next()) {
                User user = new User();
                user.setId(userId);
                user.setEmail(resSet.getString(2));
                user.setUserName(resSet.getString(3));
                user.setHashPassword(resSet.getString(4));
                return user;
            }
        } catch (SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return null;
    }

    //public static boolean updateUser (User user) {}

    //public static boolean deleteUser (int userId) {}

    //public static List<User> readAllUsers () {}








}
