
import java.time.LocalDate;
public class UserBook {
    private User user;
    private Book book;
    private LocalDate borrowDate;

    public UserBook(User user, Book book, LocalDate borrowDate) {
        this.user = user;
        this.book = book;
        this.borrowDate = borrowDate;
    }

    public String toString() {
        return user.toString() + " Trạng thái: Đã mượn " + book.toString() + " mượn ngày " + borrowDate;
    }
}
