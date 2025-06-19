package com.example.servingwebcontent;

import java.time.LocalDate;

public class BorrowRecord {
    private String bookId;
    private String borrowerName;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public BorrowRecord(String bookId, String borrowerName, LocalDate borrowDate, LocalDate dueDate) {
        this.bookId = bookId;
        this.borrowerName = borrowerName;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = null;
    }

    public String getBookId() {
        return bookId;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}