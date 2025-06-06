import java.time.LocalDate;

public class UserBook {
    private User user;
    private Book book;
    private LocalDate borrowDate;
    private LocalDate dueDate;

    public UserBook(User user, Book book, LocalDate borrowDate, int days) {
        this.user = user;
        this.book = book;
        this.borrowDate = borrowDate;
        this.dueDate = borrowDate.plusDays(days);
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }
}
