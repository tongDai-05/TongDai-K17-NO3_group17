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
        String sql = "SELECT * FROM book"; // ✅ đã sửa

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
        String sql = "SELECT * FROM book WHERE borrowed = TRUE"; // ✅ đã sửa

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
        String sql = "SELECT * FROM book WHERE bookName LIKE ? OR bookAuthor LIKE ?"; // ✅ đã sửa

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

    public Book findBookById(String id) {
        String sql = "SELECT * FROM book WHERE bookID = ?"; // ✅ đã sửa
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

    public void updateBook(Book book) {
        String sql = "UPDATE book SET bookName = ?, bookAuthor = ?, viTri = ? WHERE bookID = ?"; // ✅ đã sửa

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

    public void deleteBook(String id) {
        String sql = "DELETE FROM book WHERE bookID = ?"; // ✅ đã sửa

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, id);
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Book mapResultSetToBook(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setId(rs.getString("bookID"));
        book.setTitle(rs.getString("bookName"));     // ✅ dùng đúng tên cột SQL
        book.setAuthor(rs.getString("bookAuthor"));  // ✅
        book.setBorrowed(rs.getBoolean("borrowed"));
        book.setViTri(rs.getString("viTri"));
        return book;
    }
    public List<Book> filterBooks(String author, String viTri) {
    List<Book> books = new ArrayList<>();
    StringBuilder sql = new StringBuilder("SELECT * FROM book WHERE 1=1");

    if (author != null && !author.isEmpty()) {
        sql.append(" AND bookAuthor LIKE ?");
    }

    if (viTri != null && !viTri.isEmpty()) {
        sql.append(" AND viTri LIKE ?");
    }

    try (Connection conn = getConnection();
         PreparedStatement pst = conn.prepareStatement(sql.toString())) {

        int index = 1;
        if (author != null && !author.isEmpty()) {
            pst.setString(index++, "%" + author + "%");
        }
        if (viTri != null && !viTri.isEmpty()) {
            pst.setString(index, "%" + viTri + "%");
        }

        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            books.add(mapResultSetToBook(rs));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return books;
}

}
