package mytest;

public class User {
    private String userId;
    private String name;
    private String email;

    // Constructor
    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    // ===== Getter (Phương thức lấy thông tin) =====
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // ===== Setter (Phương thức cập nhật thông tin) =====
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // In chuỗi thông tin
    public String inchuoiString() {
        return "User(ID: " + userId + ", Name: " + name + ", Email: " + email + ")";
    }
}
