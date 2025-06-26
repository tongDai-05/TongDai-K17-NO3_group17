package com.example.servingwebcontent.database;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import com.example.servingwebcontent.Book;
import com.example.servingwebcontent.User;
import com.example.servingwebcontent.LoanRecord;

public class LoanRecordAiven {

    public LoanRecordAiven() {}

    public ArrayList<LoanRecord> getLoanRecords() {
        ArrayList<LoanRecord> records = new ArrayList<>();

        try {
            // Kết nối cơ sở dữ liệu Aiven MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://mysql-cd52b85-raznopro2k5-c07e.c.aivencloud.com:22996/defaultdb?ssl-mode=REQUIRED",
                "avnadmin", "AVNS_4nU1y6avZRmSrZ0OhWl"
            );

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM loanrecord LIMIT 50");

            while (rs.next()) {
                // Lấy thông tin sách
                String bookId = rs.getString("bookID");
                String bookTitle = rs.getString("bookName");
                String bookAuthor = rs.getString("bookAuthor");
                String bookViTri = rs.getString("bookViTri");
                LocalDate borrowDate = rs.getDate("borrowDate").toLocalDate();

                // Khởi tạo Book
                Book book = new Book(bookId, bookTitle, bookAuthor, bookViTri);
                book.muonSach(); // đánh dấu là đã mượn

                // Lấy thông tin người dùng
                String userId = rs.getString("userID");
                String userName = rs.getString("userName");
                String address = rs.getString("userAddress"); // nếu có trong CSDL

                // Khởi tạo User
                User user = new User();
                user.setUserID(userId);
                user.setUserName(userName);
                user.setAddress(address);

                // Tạo LoanRecord
                LoanRecord record = new LoanRecord(book, user, borrowDate);
                records.add(record);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Lỗi kết nối CSDL hoặc đọc dữ liệu:");
            e.printStackTrace();
        }

        return records;
    }
}
