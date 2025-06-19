package com.example.servingwebcontent.database;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;



public class aivenConnection {
    /*
     * mysql://avnadmin:AVNS_vnxIPZzh5FEUIaIZgsu@mysql-3f17dc4c-st-72c4.c.aivencloud.com:19996/defaultdb?ssl-mode=REQUIRED
     */
    public void aivenConn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                     "jdbc:mysql://avnadmin:AVNS_vnxIPZzh5FEUIaIZgsu@mysql-3f17dc4c-st-72c4.c.aivencloud.com:19996/defaultdb?ssl-mode=REQUIRED",
                    "avnadmin", "AVNS_vnxIPZzh5FEUIaIZgsu");

                  //  AAVNS_vnxIPZzh5FEUIaIZgsu
            Statement sta = conn.createStatement();
            ResultSet reset = sta.executeQuery("select * from user");
            System.out.println("Display data from database: ");
            while (reset.next()) {
                String userID = reset.getString("userId");
                String username = reset.getString("username");
                System.out.println(userID + " " + username);

            }

            reset.close();
            sta.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error in database connecion");
            System.out.println(e);
            e.printStackTrace();
        }
    }
}