package mytest.TEST;
//import Book;
//import mytest.Library;



import qli_thuvien.src.Book;

public class chuyensachTest {
    public static void run() {
        System.out.println("=== TEST CHUYỂN SÁCH ===");

        // Tạo đối tượng thư viện
        //code sai 
        
        Library lib = new Library();

        // Thêm một vài sách
        Book s1 = new Book("S001", "Lập trình C", "Nguyễn Văn A", "Kho");
        Book s2 = new Book("S002", "Cơ sở dữ liệu", "Trần Thị B", "Phòng đọc");

        lib.addBook(s1);
        lib.addBook(s2);

        // Hiển thị trước khi chuyển
        System.out.println("\nTrước khi chuyển:");
        lib.printAllBooks();

        // Chuyển sách
        System.out.println("\nThực hiện chuyển sách:");
        lib.chuyenSach("S001", "Phòng đọc");
        lib.chuyenSach("S002", "Kho mượn ngoài");

        // Hiển thị sau khi chuyển
        System.out.println("\nSau khi chuyển:");
        lib.printAllBooks();

        // Chuyển sách không tồn tại
        System.out.println("\nThử chuyển sách không tồn tại:");
        lib.chuyenSach("S999", "Phòng đọc");

        System.out.println("=== KẾT THÚC TEST ===");
    }
}
