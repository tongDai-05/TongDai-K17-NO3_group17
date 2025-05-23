package mytest.test;
public class booktest {
    public static void main(String[] args) {
        // Tạo sách
        Book book = new Book("B001", "Lập trình Java", "Tạ Thị Đại");
        System.out.println(book.inchuoiString());
    }
}
