public class Book {
    private String id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public void displayInfo() {
        System.out.println("Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable);
    }
}
