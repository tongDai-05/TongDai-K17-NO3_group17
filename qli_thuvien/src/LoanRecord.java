package qli_thuvien.src;
import java.time.LocalDate;
public class LoanRecord {
    private Book book; //ttin sach muon
    private User user; //ttin nguoi muon
    private LocalDate borrowDate; //ngay muon sach

    public LoanRecord(Book book, User user, LocalDate borrowDate){
        this.book=book;
        this.user=user;
        this.borrowDate=borrowDate; //luu lai ngay muon
    }
    public Book getBook(){ return book; }
    public User getUser(){ return user; }
    public LocalDate getBorrowDate(){ return borrowDate; }
}
