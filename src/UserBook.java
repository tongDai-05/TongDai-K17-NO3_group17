public class UserBook {
    private String bookId;
    private String userId;
    private String borrowDate;

    public UserBook(String bookId, String userId, String borrowDate) {
        this.bookId = bookId;
        this.userId = userId;
        this.borrowDate = borrowDate;
    }

    public void displayBorrowInfo() {
        System.out.println("Book ID: " + bookId + ", Borrowed by User ID: " + userId + ", On: " + borrowDate);
    }
}
