package com.example.servingwebcontent;

public class Book {
    private String id;
    private String title;
    private String author;
    private String viTri;
    private boolean borrowed;

    // ✅ Constructor mặc định
    public Book() {
    }

    // ✅ Constructor có tham số
    public Book(String id, String title, String author, String viTri) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.viTri = viTri;
        this.borrowed = false; // mặc định chưa mượn
    }

    // ✅ Getter và Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    // ✅ Gọi khi mượn sách
    public void muonSach() {
        this.borrowed = true;
    }

    // ✅ Gọi khi trả sách
    public void traSach() {
        this.borrowed = false;
    }
}
