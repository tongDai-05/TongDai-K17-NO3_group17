package com.example.servingwebcontent.database;

import com.example.servingwebcontent.Book;
import com.example.servingwebcontent.User;
import com.example.servingwebcontent.LoanRecord;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class LoanRecordAiven {

    private static final String URL = "jdbc:mysql://mysql-cd52b85-raznopro2k5-c07e.c.aivencloud.com:22996/defaultdb?ssl-mode=REQUIRED";
    private static final String USER = "avnadmin";
    private static final String PASS = "AVNS_4nU1y6avZRmSrZ0OhWl";

    public LoanRecordAiven() {}

    public ArrayList<LoanRecord> getLoanRecords() {
        ArrayList<LoanRecord> records = new ArrayList<>();

        String query = "SELECT * FROM loanrecord";  // bạn có thể giới hạn bằng LIMIT nếu cần

        try (
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)
        ) {
            while (rs.next()) {
                // 📚 Lấy thông tin sách
                String bookId = rs.getString("bookID");
                String bookTitle = rs.getString("bookName");
                String bookAuthor = rs.getString("bookAuthor");
                String bookViTri = rs.getString("bookViTri");
                LocalDate borrowDate = rs.getDate("borrowDate").toLocalDate();

                Book book = new Book(bookId, bookTitle, bookAuthor, bookViTri);
                book.muonSach(); // đánh dấu sách đã mượn

                // 👤 Lấy thông tin người dùng
                String userId = rs.getString("userID");
                String userName = rs.getString("userName");
                String address = rs.getString("userAddress");

                User user = new User();
                user.setUserID(userId);
                user.setUserName(userName);
                user.setAddress(address);

                // 📝 Gộp thành bản ghi mượn
                LoanRecord record = new LoanRecord(book, user, borrowDate);
                records.add(record);
            }

        } catch (Exception e) {
            System.out.println("❌ Lỗi khi truy vấn dữ liệu mượn sách:");
            e.printStackTrace();
        }

        return records;
    }
}
