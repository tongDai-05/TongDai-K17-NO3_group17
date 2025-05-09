// App.java (test main)
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        User user = new User(1, "Nguyen Van A", "a@example.com");
        Book book = new Book(101, "Lập trình Java", "Tác giả A");
        UserBook borrow = new UserBook(user, book, LocalDate.now());

        System.out.println(user);
        System.out.println(book);
        System.out.println(borrow);
    }
}
