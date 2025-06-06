package qli_thuvien.test;

import qli_thuvien.src.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class LoanRecordTest {
    public static void main(String[] args) {
        // Danh sách ghi nhận mượn sách
        ArrayList<LoanRecord> records = new ArrayList<>();

        // Tạo sách và người dùng mẫu
        Book book1 = new Book("B01", "Lập trình Java", "Nguyễn Văn A");
        Book book2 = new Book("B02", "Cấu trúc dữ liệu", "Lê Văn B");
        User user1 = new User("U01", "Trần Thị C");
        User user2 = new User("U02", "Phạm Văn D");

        // Giả lập mượn sách
        records.add(new LoanRecord(book1, user1, LocalDate.of(2025, 5, 30)));
        records.add(new LoanRecord(book2, user2, LocalDate.of(2025, 5, 29)));

        // Nhập ngày cần tra cứu
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ngày cần kiểm tra (yyyy-mm-dd): ");
        String inputDate = sc.nextLine();
        LocalDate targetDate = LocalDate.parse(inputDate);

        System.out.println("\n Danh sách sách được mượn vào ngày " + targetDate + ":");
        for (LoanRecord record : records) {
            if (record.getBorrowDate().equals(targetDate)) {
                System.out.println("- " + record.getBook().getTensach() + " (Người mượn: " + record.getUser().getName() + ")");
            }
        }
    }
}
