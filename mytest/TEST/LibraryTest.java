package mytest.TEST;
public class LibraryTest {
    public static void run() {
        System.out.println("→ BẮT ĐẦU TEST CRUD ←");

        // Tạo thư viện
        Library lib = new Library();

        // ===== CREATE =====
        System.out.println("\n[CREATE] Thêm sách:");
        Book b1 = new Book("B001", "Lập trình Java", "Nguyễn Văn A", "Kho");
        Book b2 = new Book("B002", "Cấu trúc dữ liệu", "Trần Thị B", "Phòng đọc");
        lib.addBook(b1);
        lib.addBook(b2);
        lib.printAllBooks();

        // ===== READ =====
        System.out.println("\n[READ] Hiển thị danh sách sách hiện có:");
        lib.printAllBooks();

        // ===== UPDATE =====
        System.out.println("\n[UPDATE] Sửa thông tin sách B002:");
        lib.editBook("B002", "Cấu trúc DL & Giải thuật", "Trần Thị Bích");
        lib.printAllBooks();

        // ===== DELETE =====
        System.out.println("\n[DELETE] Xóa sách B001:");
        lib.deleteBook("B001");
        lib.printAllBooks();

        // Thử xóa sách không tồn tại
        System.out.println("\n[DELETE] Xóa sách không tồn tại (B999):");
        lib.deleteBook("B999");

        System.out.println("\n→ KẾT THÚC TEST CRUD ←");
    }
}
