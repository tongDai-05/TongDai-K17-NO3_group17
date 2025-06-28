package com.example.servingwebcontent.model;

import java.time.LocalDate;

public class BorrowRecord {
    private String recordId;         // Mã phiếu mượn (tuỳ chọn)
    private String bookId;
    private String borrowerId;       // Mã người mượn ( liên kết với User)
    private String borrowerName;     // Tên người mượn 
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    // Constructor mặc định
    public BorrowRecord() {}

    // Constructor đầy đủ
    public BorrowRecord(String recordId, String bookId, String borrowerId, String borrowerName,
                        LocalDate borrowDate, LocalDate dueDate) {
        this.recordId = recordId;
        this.bookId = bookId;
        this.borrowerId = borrowerId;
        this.borrowerName = borrowerName;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = null;
    }

    // Getter - Setter

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    // Kiểm tra quá hạn
    public boolean isOverdue() {
        return returnDate == null && LocalDate.now().isAfter(dueDate);
    }
}
