package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.User;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserAiven {

    private final String URL = "jdbc:mysql://avnadmin:AVNS_4nU1y6avZRmSrZ0OhWl@mysql-cd52b85-raznopro2k5-c07e.c.aivencloud.com:22996/defaultdb?ssl-mode=REQUIRED";
    private final String USER = "avnadmin";
    private final String PASS = "AVNS_4nU1y6avZRmSrZ0OhWl";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                users.add(mapResultSetToUser(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public User findUserById(String id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return mapResultSetToUser(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertUser(User user) {
        String sql = "INSERT INTO user (id, name, address) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, user.getUserID());
            pst.setString(2, user.getUserName());
            pst.setString(3, user.getAddress());

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        String sql = "UPDATE user SET name = ?, address = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, user.getUserName());
            pst.setString(2, user.getAddress());
            pst.setString(3, user.getUserID());

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String userID) {
        String sql = "DELETE FROM user WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, userID);
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private User mapResultSetToUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUserID(rs.getString("id"));
        user.setUserName(rs.getString("name"));
        user.setAddress(rs.getString("address"));
        return user;
    }
}
