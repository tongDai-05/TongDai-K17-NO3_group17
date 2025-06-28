package com.example.servingwebcontent.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BorrowBookAiven {
    public void borrowBook(String bookID) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://avnadmin:AVNS_4nU1y6avZRmSrZ0OhWl@mysql-cd52b85-raznopro2k5-c07e.c.aivencloud.com:22996/defaultdb?ssl-mode=REQUIRED",
                "avnadmin", "AVNS_4nU1y6avZRmSrZ0OhWl")) {

            String query = "UPDATE book SET borrowed = TRUE WHERE bookID = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, bookID);
            int rows = pst.executeUpdate();

            if (rows == 0) {
                System.out.println("❌ Không tìm thấy sách với ID: " + bookID);
            } else {
                System.out.println("✅ Đã mượn sách: " + bookID);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

