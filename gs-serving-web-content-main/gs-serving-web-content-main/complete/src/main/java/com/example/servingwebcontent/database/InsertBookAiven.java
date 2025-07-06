package com.example.servingwebcontent.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.example.servingwebcontent.model.Book;

public class InsertBookAiven {
    public void insertBook(Book book) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://avnadmin:AVNS_4nU1y6avZRmSrZ0OhWl@mysql-cd52b85-raznopro2k5-c07e.c.aivencloud.com:22996/defaultdb?ssl-mode=REQUIRED",
                "avnadmin", "AVNS_4nU1y6avZRmSrZ0OhWl")) {

             String query = "INSERT INTO book(bookID, bookName, bookAuthor, borrowed, viTri) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, book.getId());          // sửa getBookID() → getId()
            pst.setString(2, book.getTitle());
            pst.setString(3, book.getAuthor());
            pst.setBoolean(4, book.isBorrowed());
            pst.setString(5, book.getViTri());       // thêm vị trí (nếu dùng)
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
