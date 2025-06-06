// MuonSachTest.java
import java.util.ArrayList;

public class MuonSachTest {
    public static void run() {

        Library lib = new Library();
        ArrayList<UserBook> dsMuon = new ArrayList<>();

        Book b1 = new Book("B001", "Lập trình Java", "Tạ Thị Đại", "Kệ 1");
        Book b2 = new Book("B002", "Cơ sở dữ liệu", "Nguyễn Văn A", "Kệ 2");
        lib.addBook(b1);
        lib.addBook(b2);

        User u1 = new User("U001", "Nguyễn Văn A", "a@gmail.com");
        User u2 = new User("U002", "Trần Thị B", "b@gmail.com");

        lib.inSachCoTheMuon();

        lib.muonSach("B001", u1, dsMuon);
        lib.muonSach("B001", u2, dsMuon);
        lib.muonSach("B002", u2, dsMuon);

        System.out.println("\nDanh sách mượn sách:");
        for (UserBook ub : dsMuon) {
            System.out.println(ub.getUser().getName() + " mượn " + ub.getBook().tensach +
            " | Ngày mượn: " + ub.getBorrowDate() +
            " | Hạn trả: " + ub.getDueDate());

        }

    }
}