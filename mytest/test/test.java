import java.time.LocalDate;
import java.util.Scanner;
public class test {
    public static void test(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập thông tin người dùng
        System.out.print("Nhập ID người dùng: ");
        String userId = scanner.nextLine();

        System.out.print("Nhập tên người dùng: ");
        String name = scanner.nextLine();

        System.out.print("Nhập email người dùng: ");
        String email = scanner.nextLine();

        User user = new User(userId, name, email);

        // Nhập thông tin sách
        System.out.print("Nhập ID sách: ");
        String bookId = scanner.nextLine();

        System.out.print("Nhập tiêu đề sách: ");
        String title = scanner.nextLine();

        System.out.print("Nhập tên tác giả: ");
        String author = scanner.nextLine();

        Book book = new Book(bookId, title, author);

        // Tạo bản ghi mượn sách
        UserBook borrow = new UserBook(user, book, LocalDate.now());

        // In thông tin ra màn hình
        System.out.println("\n--- THÔNG TIN ---");
        System.out.println(user);
        System.out.println(book);
        System.out.println(borrow);

        scanner.close();
    }
}

