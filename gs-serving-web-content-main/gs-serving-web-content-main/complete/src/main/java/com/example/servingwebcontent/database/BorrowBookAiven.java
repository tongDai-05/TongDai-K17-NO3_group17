package com.example.servingwebcontent.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BorrowBookAiven {
    public void borrowBook(String bookID) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://...your_url_here...",
                "avnadmin", "your_password")) {

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

