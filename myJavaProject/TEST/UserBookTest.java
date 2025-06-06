import java.time.LocalDate;

public class UserBookTest {
    public static void run(String[] args) {
        User u = new User("U01", "Nguyễn Văn A", "a@gmail.com");
        Book b = new Book("B01", "Toán học", "Nguyễn Văn B", "Kệ A");
        LocalDate date = LocalDate.of(2025, 5, 9);

        UserBook ub = new UserBook(u, b, date);
        System.out.println(ub);
    }
}
