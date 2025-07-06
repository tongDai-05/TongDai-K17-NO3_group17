package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.BorrowRecord;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class BorrowRecordAiven {

    private final String URL = "jdbc:mysql://avnadmin:AVNS_4nU1y6avZRmSrZ0OhWl@mysql-cd52b85-raznopro2k5-c07e.c.aivencloud.com:22996/defaultdb?ssl-mode=REQUIRED";
    private final String USER = "avnadmin";
    private final String PASS = "AVNS_4nU1y6avZRmSrZ0OhWl";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public List<BorrowRecord> getAllRecords() {
        List<BorrowRecord> list = new ArrayList<>();
        String sql = "SELECT * FROM borrow_records";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(map(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public BorrowRecord findById(String recordId) {
        String sql = "SELECT * FROM borrow_records WHERE recordId = ?";
        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, recordId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return map(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insert(BorrowRecord br) {
        String sql = "INSERT INTO borrow_records (recordId, bookId, borrowerId, borrowerName, borrowDate, dueDate, returnDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, br.getRecordId());
            pst.setString(2, br.getBookId());
            pst.setString(3, br.getBorrowerId());
            pst.setString(4, br.getBorrowerName());
            pst.setDate(5, Date.valueOf(br.getBorrowDate()));
            pst.setDate(6, Date.valueOf(br.getDueDate()));
            pst.setDate(7, br.getReturnDate() != null ? Date.valueOf(br.getReturnDate()) : null);

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(BorrowRecord br) {
        String sql = "UPDATE borrow_records SET bookId=?, borrowerId=?, borrowerName=?, borrowDate=?, dueDate=?, returnDate=? WHERE recordId=?";
        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, br.getBookId());
            pst.setString(2, br.getBorrowerId());
            pst.setString(3, br.getBorrowerName());
            pst.setDate(4, Date.valueOf(br.getBorrowDate()));
            pst.setDate(5, Date.valueOf(br.getDueDate()));
            pst.setDate(6, br.getReturnDate() != null ? Date.valueOf(br.getReturnDate()) : null);
            pst.setString(7, br.getRecordId());

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String recordId) {
        String sql = "DELETE FROM borrow_records WHERE recordId=?";
        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, recordId);
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private BorrowRecord map(ResultSet rs) throws SQLException {
        BorrowRecord br = new BorrowRecord();
        br.setRecordId(rs.getString("recordId"));
        br.setBookId(rs.getString("bookId"));
        br.setBorrowerId(rs.getString("borrowerId"));
        br.setBorrowerName(rs.getString("borrowerName"));
        br.setBorrowDate(rs.getDate("borrowDate").toLocalDate());
        br.setDueDate(rs.getDate("dueDate").toLocalDate());
        Date returnDate = rs.getDate("returnDate");
        if (returnDate != null) {
            br.setReturnDate(returnDate.toLocalDate());
        }
        return br;
    }
    public void deleteByBookId(String bookId) {
        String sql = "DELETE FROM borrow_records WHERE bookId=?";
        try (Connection conn = getConnection();
         PreparedStatement pst = conn.prepareStatement(sql)) {
        pst.setString(1, bookId);
        pst.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
