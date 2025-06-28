package com.example.servingwebcontent.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

import com.example.servingwebcontent.model.User;

public class InsertToAiven {

    public void insertToAivenDb(User u) {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                "jdbc:mysql://mysql-cd52b85-raznopro2k5-c07e.c.aivencloud.com:22996/defaultdb?ssl-mode=REQUIRED",
                "avnadmin", "AVNS_4nU1y6avZRmSrZ0OhWl");

            // Random userId
            Random rand = new Random();
            String userIdVal = "u" + rand.nextInt(1000);

            String sql = "INSERT INTO user(userId, username, address) VALUES (?, ?, ?)";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, userIdVal);
                pst.setString(2, u.getUserName());
                pst.setString(3, u.getAddress());
                pst.executeUpdate();
            }

            System.out.println("User inserted into database successfully.");

        } catch (Exception e) {
            System.out.println("Error in database connection:");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
