package com.example.servingwebcontent.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.example.servingwebcontent.Book;

public class InsertBookAiven {
    public void insertBook(Book book) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://avnadmin:AVNS_-S5Osd1skj7kmlcho-3@mysql-14737a33-nglthu-4e05.k.aivencloud.com:17237/defaultdb?ssl-mode=REQUIRED",
                "sqluser", "password")) {

            String query = "INSERT INTO books(bookID, title, author, borrowed) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, book.getBookID());
            pst.setString(2, book.getTitle());
            pst.setString(3, book.getAuthor());
            pst.setBoolean(4, book.isBorrowed());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
