package qli_thuvien.test;

import qli_thuvien.src.Book;
import qli_thuvien.src.UserBook;

public class TestUserBook {
    public static void main(String[] args) {
        // Tạo đối tượng UserBook
        UserBook ub = new UserBook();

        // Tạo vài quyển sách
        Book book1 = new Book("S01", "Lập trình Java", "Đang mượn");
        Book book2 = new Book("S02", "Cơ sở dữ liệu", "Đang mượn");
        Book book3 = new Book("S03", "Hệ điều hành", "Đang mượn");

        // Test: Thêm sách
        ub.addBook(book1);
        ub.addBook(book2);
        ub.addBook(book3);

        System.out.println("==> Sau khi thêm sách:");
        ub.printUserBook();

        // Test: Sửa tên sách
        ub.getEditBook("S02", "CSDL nâng cao");

        System.out.println("\n==> Sau khi sửa tên sách S02:");
        ub.printUserBook();

        // Test: Xoá sách
        ub.getDeleBook("S01");

        System.out.println("\n==> Sau khi xoá sách S01:");
        ub.printUserBook();
    }
}
