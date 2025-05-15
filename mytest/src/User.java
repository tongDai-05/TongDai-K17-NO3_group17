// User.java
public class User {
    private String userId;
    private String name;
    private String email;

    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public String inchuoiString() {
        return "User(ID: " + userId + ", Name: " + name + ", Email: " + email + ")";
    }
}
