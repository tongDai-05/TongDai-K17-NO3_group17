package library;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LibraryTest {
    public static void testMethod2() {
        Library library = new Library();

        // Thêm dữ liệu mẫu
        library.addBook(new Book("B001", "Lập trình Java"));
        library.addBook(new Book("B002", "Cấu trúc dữ liệu"));

        library.addBorrowRecord(new BorrowRecord("B001", "Nguyễn Văn A", 
            LocalDate.parse("23/05/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 
            LocalDate.parse("30/05/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        library.addBorrowRecord(new BorrowRecord("B002", "Trần Thị B", 
            LocalDate.parse("20/05/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 
            LocalDate.parse("30/05/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"))));

        // Kiểm thử trả sách
        System.out.println("=== Kiểm thử trả sách ===");
        library.returnBook("B001", "30/05/2025"); // Thành công
        library.returnBook("B999", "30/05/2025"); // Thất bại (sách không tồn tại)
        library.returnBook("B001", "30/05/2025"); // Thất bại (sách đã trả)
        library.returnBook("B002", "invalid_date"); // Thất bại (ngày sai định dạng)

        // Kiểm thử hiển thị sách đến hạn hoặc đã trả
        System.out.println("\n=== Kiểm thử hiển thị sách đến hạn hoặc đã trả ===");
        library.displayBooksDueOnDate("30/05/2025"); // Hiển thị sách B001 (đã trả), B002 (đến hạn)
        library.displayBooksDueOnDate("31/05/2025"); // Không có sách
        library.displayBooksDueOnDate("invalid_date"); // Ngày sai định dạng
    }
}