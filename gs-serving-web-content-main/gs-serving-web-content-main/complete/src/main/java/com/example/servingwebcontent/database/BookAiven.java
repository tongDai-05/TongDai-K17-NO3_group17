package com.example.servingwebcontent.database;

import com.example.servingwebcontent.Book;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookAiven {

    private final String URL = "jdbc:mysql://avnadmin:AVNS_4nU1y6avZRmSrZ0OhWl@mysql-cd52b85-raznopro2k5-c07e.c.aivencloud.com:22996/defaultdb?ssl-mode=REQUIRED";
    private final String USER = "avnadmin";
    private final String PASS = "AVNS_4nU1y6avZRmSrZ0OhWl";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                books.add(mapResultSetToBook(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    public List<Book> getBorrowedBooks() {
        List<Book> borrowedBooks = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE borrowed = TRUE";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                borrowedBooks.add(mapResultSetToBook(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return borrowedBooks;
    }

    public List<Book> searchBooks(String keyword) {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE title LIKE ? OR author LIKE ?";

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            String searchPattern = "%" + keyword + "%";
            pst.setString(1, searchPattern);
            pst.setString(2, searchPattern);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                books.add(mapResultSetToBook(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }

    // ✅ Tìm sách theo ID (dùng cho form chỉnh sửa)
    public Book findBookById(String id) {
        String sql = "SELECT * FROM books WHERE bookID = ?";
        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return mapResultSetToBook(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // ✅ Cập nhật thông tin sách
    public void updateBook(Book book) {
        String sql = "UPDATE books SET title = ?, author = ?, viTri = ? WHERE bookID = ?";

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, book.getTitle());
            pst.setString(2, book.getAuthor());
            pst.setString(3, book.getViTri());
            pst.setString(4, book.getId());

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ✅ Xóa sách theo ID
    public void deleteBook(String id) {
        String sql = "DELETE FROM books WHERE bookID = ?";

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, id);
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ✅ Hàm hỗ trợ ánh xạ dữ liệu từ ResultSet sang Book
    private Book mapResultSetToBook(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setId(rs.getString("bookID"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setBorrowed(rs.getBoolean("borrowed"));
        book.setViTri(rs.getString("viTri"));
        return book;
    }
}
