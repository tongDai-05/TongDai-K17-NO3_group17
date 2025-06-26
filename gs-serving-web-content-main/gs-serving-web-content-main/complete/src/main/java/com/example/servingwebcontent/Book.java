package com.example.servingwebcontent;

public class Book {
    private String id;          // Đổi từ bookID → id
    private String title;
    private String author;
    private boolean borrowed;
    private String viTri;

    public Book() {}

    public Book(String id, String title, String author, String viTri) {
        this.id = id;                     // Đổi tên biến
        this.title = title;
        this.author = author;
        this.viTri = viTri;
        this.borrowed = false;
    }

    // Getter và Setter cho id
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public boolean isBorrowed() { return borrowed; }
    public void setBorrowed(boolean borrowed) { this.borrowed = borrowed; }

    public String getViTri() { return viTri; }
    public void setViTri(String viTri) { this.viTri = viTri; }

    public void muonSach() {
        this.borrowed = true;
    }
}
