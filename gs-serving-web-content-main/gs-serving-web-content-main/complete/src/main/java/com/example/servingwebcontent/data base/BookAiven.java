package com.example.servingwebcontent.database;

import java.sql.*;
import java.util.ArrayList;
import com.example.servingwebcontent.Book;

public class BookAiven {

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://avnadmin:AVNS_-S5Osd1skj7kmlcho-3@mysql-14737a33-nglthu-4e05.k.aivencloud.com:17237/defaultdb?ssl-mode=REQUIRED",
                "sqluser", "password");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM books")) {

            while (rs.next()) {
                Book book = new Book();
                book.setBookID(rs.getString("bookID"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setBorrowed(rs.getBoolean("borrowed"));
                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }
}
