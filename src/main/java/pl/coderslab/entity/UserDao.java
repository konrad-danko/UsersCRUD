package pl.coderslab.entity;

import pl.coderslab.utils.DbUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private static final String CREATE_USER_QUERY = "INSERT INTO users (email, username, password) values (?,?,?)";
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

    private static final String READ_USER_QUERY = "SELECT * FROM users WHERE id=?";
    public static User readUser (long userId) {
        try (Connection conn = DbUtil.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(READ_USER_QUERY)) {
            prepStat.setLong(1, userId);
            try (ResultSet resSet = prepStat.executeQuery()) {
                if (resSet.next()) {
                    User user = new User();
                    user.setId(userId);
                    user.setEmail(resSet.getString(2));
                    user.setUserName(resSet.getString(3));
                    user.setHashPassword(resSet.getString(4));
                    return user;
                }
            }
        } catch (SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return null;
    }
    
    private static final String UPDATE_USER_QUERY = "UPDATE users SET email=?, username=?, password=? WHERE id=?";
    public static boolean updateUser (User user) {
        try (Connection conn = DbUtil.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(UPDATE_USER_QUERY)){
            prepStat.setString(1, user.getEmail());
            prepStat.setString(2, user.getUserName());
            prepStat.setString(3, user.getPassword());
            prepStat.setLong(4, user.getId());
            prepStat.executeUpdate();
            return true;
        } catch (SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }

    private static final String DELETE_USER_QUERY = "DELETE FROM users WHERE id=?";
    public static boolean deleteUser (int userId) {
        try(Connection conn = DbUtil.getConnection(); //******************************
        PreparedStatement prepStat = conn.prepareStatement(DELETE_USER_QUERY)){
            prepStat.setLong(1, userId);
            prepStat.executeUpdate();
            return true;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private static final String READ_ALL_USERS_QUERY = "SELECT * FROM users ORDER BY id, username, email";
    public static List<User> readAllUsers () {
        List<User> userList = new ArrayList<>();
        try(Connection conn = DbUtil.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(READ_ALL_USERS_QUERY)){
            try (ResultSet resSet = prepStat.executeQuery()) {
                while (resSet.next()) {
                    User user = new User();
                    user.setId(resSet.getLong(1));
                    user.setUserName(resSet.getString(3));
                    user.setEmail(resSet.getString(2));
                    user.setHashPassword(resSet.getString(4));
                    userList.add(user);
                }
                return userList;
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
            return userList;
        }
    }
}
