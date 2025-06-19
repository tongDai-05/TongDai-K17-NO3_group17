package com.example.servingwebcontent.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://avnadmin:AVNS_vnxIPZzh5FEUIaIZgsu@mysql-3f17dc4c-st-72c4.c.aivencloud.com:19996/defaultdb?ssl-mode=REQUIRED",
                "avnadmin", "AVNS_vnxIPZzh5FEUIaIZgsu"
            );

            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM loanrecord LIMIT 20");

            while (rs.next()) {
                String masach = rs.getString("bookID");
                String tensach = rs.getString("bookName");     // dữ liệu tên sách
                String tacgia = rs.getString("bookAuthor");    // dữ liệu tác giả
                String maUser = rs.getString("userID");
                String hoten = rs.getString("userName");       // dữ liệu tên người dùng
                LocalDate borrowDate = rs.getDate("borrowDate").toLocalDate();

                Book book = new Book(masach, tensach, tacgia);
                book.muonsach(); // cập nhật trạng thái đã mượn

                User user = new User(maUser, hoten);
                LoanRecord record = new LoanRecord(book, user, borrowDate);

                records.add(record);
            }

            rs.close();
            sta.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Lỗi kết nối CSDL hoặc đọc dữ liệu:");
            e.printStackTrace();
        }

        return records;
    }
}
