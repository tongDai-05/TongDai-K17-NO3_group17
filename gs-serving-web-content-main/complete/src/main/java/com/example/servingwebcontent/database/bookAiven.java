package com.example.servingwebcontent.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.servingwebcontent.Book;

public class bookAiven {

    public bookAiven() {}

    ArrayList<Book> items = new ArrayList<>();

    public ArrayList<Book> bookAivenList() {

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                "jdbc:mysql://avnadmin:AVNS_vnxIPZzh5FEUIaIZgsu@mysql-3f17dc4c-st-72c4.c.aivencloud.com:19996/defaultdb?ssl-mode=REQUIRED",
                "avnadmin", "AVNS_vnxIPZzh5FEUIaIZgsu");

            Statement sta = conn.createStatement();
            ResultSet setdata = sta.executeQuery("SELECT * FROM book LIMIT 10");

            while (setdata.next()) {
                String masach = setdata.getString("bookID");
                String tensach = setdata.getString("bookName");
                String tacgia = setdata.getString("bookAuthor");

                Book book = new Book(masach, tensach, tacgia);

                System.out.println("Đã lấy sách từ DB:");
                book.displayInfo();

                items.add(book);
            }

            setdata.close();
            sta.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Lỗi kết nối CSDL:");
            e.printStackTrace();
        }

        return items;
    }
}