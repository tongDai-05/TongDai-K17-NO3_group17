package com.example.servingwebcontent;

public class Book {
    private String bookID;
    private String title;
    private String author;
    private boolean borrowed;
    private String viTri; // 👈 Thêm dòng này để khai báo viTri

    public Book() {}

    public Book(String bookID, String title, String author, String viTri) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.viTri = viTri;
        this.borrowed = false;
    }

    public String getBookID() { return bookID; }
    public void setBookID(String bookID) { this.bookID = bookID; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public boolean isBorrowed() { return borrowed; }
    public void setBorrowed(boolean borrowed) { this.borrowed = borrowed; }

    public String getViTri() { return viTri; }               // 👈 Getter
    public void setViTri(String viTri) { this.viTri = viTri; } // 👈 Setter
    public void muonSach() {
    this.borrowed = true;
}

}
