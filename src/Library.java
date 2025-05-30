// File: src/Library.java
package library;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<BorrowRecord> borrowRecords;

    public Library() {
        books = new ArrayList<>();
        borrowRecords = new ArrayList<>();
    }

    // Thêm sách (dùng trong kiểm thử)
    public void addBook(Book book) {
        books.add(book);
    }

    // Thêm bản ghi mượn (dùng trong kiểm thử)
    public void addBorrowRecord(BorrowRecord record) {
        borrowRecords.add(record);
    }

    // Phương thức 2: Xử lý trả sách
    public void returnBook(String bookId, String returnDateStr) {
        try {
            LocalDate returnDate = LocalDate.parse(returnDateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            for (BorrowRecord record : borrowRecords) {
                if (record.getBookId().equals(bookId) && record.getReturnDate() == null) {
                    record.setReturnDate(returnDate);
                    System.out.println("Trả sách thành công cho sách ID: " + bookId);
                    return;
                }
            }
            System.out.println("Không tìm thấy bản ghi mượn hợp lệ cho sách ID: " + bookId);
        } catch (Exception e) {
            System.out.println("Lỗi: Ngày nhập không đúng định dạng (dd/MM/yyyy).");
        }
    }

    // Phương thức 2: Hiển thị sách đến hạn hoặc đã trả trong ngày
    public void displayBooksDueOnDate(String inputDate) {
        try {
            LocalDate date = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.println("Danh sách sách đến hạn hoặc đã trả ngày " + inputDate + ":");
            boolean found = false;

            for (BorrowRecord record : borrowRecords) {
                if (record.getDueDate().equals(date) || 
                    (record.getReturnDate() != null && record.getReturnDate().equals(date))) {
                    for (Book book : books) {
                        if (book.getBookId().equals(record.getBookId())) {
                            String status = (record.getReturnDate() != null) ? "Đã trả" : "Đến hạn";
                            System.out.println("Sách: " + book.getTitle() + ", Trạng thái: " + status);
                            found = true;
                            break;
                        }
                    }
                }
            }

            if (!found) {
                System.out.println("Không có sách nào đến hạn hoặc đã trả trong ngày này.");
            }
        } catch (Exception e) {
            System.out.println("Lỗi: Ngày nhập không đúng định dạng (dd/MM/yyyy).");
        }
    }
}