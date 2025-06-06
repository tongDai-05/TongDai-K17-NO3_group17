// Library.java
import java.util.ArrayList;
import java.time.LocalDate;

public class Library {
    ArrayList<Book> bookList = new ArrayList<>();

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void printAllBooks() {
        for (Book b : bookList) {
            b.displayInfo();
        }
    }

    public void timSach(String keyword) {
        boolean found = false;
        for (Book b : bookList) {
            if (b.masach.contains(keyword) || b.tensach.toLowerCase().contains(keyword.toLowerCase()) || b.tacgia.toLowerCase().contains(keyword.toLowerCase())) {
                b.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách phù hợp.");
        }
    }

    public void muonSach(String masach, User user, ArrayList<UserBook> dsMuon) {
        for (Book b : bookList) {
            if (b.masach.equalsIgnoreCase(masach)) {
                if (!b.trangthaiMuon) {
                    b.muonsach();
                    LocalDate today = LocalDate.now();
                    UserBook ub = new UserBook(user, b, today, 14);
                    dsMuon.add(ub);
                    System.out.println("Mượn thành công sách: " + b.tensach);
                    System.out.println("Hạn trả: " + ub.getDueDate());
                } else {
                    System.out.println("Sách đã được mượn.");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy sách có mã: " + masach);
    }

    public void inSachCoTheMuon() {
        for (Book b : bookList) {
            if (!b.trangthaiMuon) {
                b.displayInfo();
            }
        }
    }

    public void chuyenSach(String maSach, String viTriMoi) {
        for (Book b : bookList) {
            if (b.masach.equals(maSach)) {
                String viTriCu = b.vitri;
                b.vitri = viTriMoi;
                System.out.println("Đã chuyển sách \"" + b.tensach + "\" từ " + viTriCu + " sang " + viTriMoi);
                return;
            }
        }
        System.out.println("Không tìm thấy sách để chuyển.");
    }
}
