
import java.util.ArrayList;
public class Library {
    ArrayList<Book> bookList = new ArrayList<>();

    // CREATE
    public void addBook(Book book) {
        bookList.add(book);
    }

    // READ
    public void printAllBooks() {
        for (Book b : bookList) {
            b.displayInfo();
        }
    }

    // UPDATE
    public void editBook(String masach, String newTensach, String newTacgia) {
        for (Book b : bookList) {
            if (b.masach.equals(masach)) {
                b.tensach = newTensach;
                b.tacgia = newTacgia;
                System.out.println("Thông tin sách đã được cập nhật.");
                return;
            }
        }
        System.out.println("Không tìm thấy sách có mã: " + masach);
    }

    // DELETE
    public void deleteBook(String masach) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).masach.equals(masach)) {
                bookList.remove(i);
                System.out.println("Đã xóa sách có mã: " + masach);
                return;
            }
        }
        System.out.println("Không tìm thấy sách để xóa.");
    }


}


}


