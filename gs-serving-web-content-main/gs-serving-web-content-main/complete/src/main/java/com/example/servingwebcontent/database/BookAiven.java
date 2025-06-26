package com.example.servingwebcontent.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.example.servingwebcontent.Book;
@Component
public class BookAiven {

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://avnadmin:AVNS_4nU1y6avZRmSrZ0OhWl@mysql-cd52b85-raznopro2k5-c07e.c.aivencloud.com:22996/defaultdb?ssl-mode=REQUIRED",
                "avnadmin", "AVNS_4nU1y6avZRmSrZ0OhWl");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM books")) {

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getString("bookID"));  // Đổi từ setBookID → setId
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setBorrowed(rs.getBoolean("borrowed"));
                book.setViTri(rs.getString("viTri")); // Nếu bạn có cột này trong DB
                books.add(book);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    public List<Book> getBorrowedBooks() {
        List<Book> borrowedBooks = new ArrayList<>();
        for (Book book : getAllBooks()) {
            if (book.isBorrowed()) {
                borrowedBooks.add(book);
            }
        }
        return borrowedBooks;
    }
}
