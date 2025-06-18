package com.example.servingwebcontent.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ReturnBookAiven {
    public void returnBook(String bookID) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://avnadmin:AVNS_-S5Osd1skj7kmlcho-3@mysql-14737a33-nglthu-4e05.k.aivencloud.com:17237/defaultdb?ssl-mode=REQUIRED",
                "sqluser", "password")) {

            String query = "UPDATE books SET borrowed = FALSE WHERE bookID = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, bookID);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
