package com.example.servingwebcontent.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AivenConnection {

    public void aivenConn() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                "jdbc:mysql://mysql-cd52b85-raznopro2k5-c07e.c.aivencloud.com:22996/defaultdb?ssl-mode=REQUIRED",
                "avnadmin", "AVNS_4nU1y6avZRmSrZ0OhWl");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user");

            System.out.println("Display data from database:");

            while (rs.next()) {
                String userID = rs.getString("userId");
                String username = rs.getString("username");
                String address = rs.getString("address");
                System.out.println(userID + " " + username + " " + address);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error in database connection");
            e.printStackTrace();
        }
    }
}
