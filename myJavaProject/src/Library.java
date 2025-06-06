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
            System.out.println("Kh\u00f4ng t\u00ecm th\u1ea5y s\u00e1ch ph\u00f9 h\u1ee3p.");
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
                    System.out.println("M\u01b0\u1ee3n th\u00e0nh c\u00f4ng sách: " + b.tensach);
                    System.out.println("H\u1ea1n tr\u1ea3: " + ub.getDueDate());
                } else {
                    System.out.println("S\u00e1ch \u0111\u00e3 \u0111\u01b0\u1ee3c m\u01b0\u1ee3n.");
                }
                return;
            }
        }
        System.out.println("Kh\u00f4ng t\u00ecm th\u1ea5y sách có mã: " + masach);
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
                System.out.println("\u0110\u00e3 chuy\u1ec3n sách " + b.tensach + " t\u1eeb " + viTriCu + " sang " + viTriMoi);
                return;
            }
        }
        System.out.println("Không tìm thấy sách để chuyển.");
    }
}