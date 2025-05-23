package test;
import mytest.User;
public class usertest {
    public static void main(String[] args) {
        User user = new User("U001", "Nguyễn Văn A", "a@gmail.com");

        // In thông tin ban đầu
        System.out.println(user.inchuoiString());

        // Sử dụng setter để thay đổi thông tin
        user.setName("Nguyễn Văn B");
        user.setEmail("b@gmail.com");

        // Sử dụng getter để truy xuất thông tin
        System.out.println("Tên mới: " + user.getName());
        System.out.println("Email mới: " + user.getEmail());
    }
}
