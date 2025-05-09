// User.java
public class User {
    private int userId;
    private String name;
    private String email;

    public User(int userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public String toString() {
        return "User(ID: " + userId + ", Name: " + name + ", Email: " + email + ")";
    }
}
