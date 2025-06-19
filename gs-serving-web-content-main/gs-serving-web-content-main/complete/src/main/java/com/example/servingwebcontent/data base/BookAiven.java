package com.example.servingwebcontent.database;

import java.sql.*;
import java.util.ArrayList;
import com.example.servingwebcontent.Book;

public class BookAiven {

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(
                "mysql://avnadmin:AVNS_4nU1y6avZRmSrZ0OhWl@mysql-cd52b85-raznopro2k5-c07e.c.aivencloud.com:22996/defaultdb?ssl-mode=REQUIRED",
                    "avnadmin", "AVNS_4nU1y6avZRmSrZ0OhWl");
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
