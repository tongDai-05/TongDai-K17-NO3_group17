package com.example.servingwebcontent;

public class Book {
    private String id;         
    private String title;
    private String author;
    private boolean borrowed;
    private String viTri;

    // ✅ Constructor mặc định (bắt buộc cần có cho Spring + DB)
    public Book() {}

    // ✅ Constructor đầy đủ
    public Book(String id, String title, String author, String viTri) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.viTri = viTri;
        this.borrowed = false;  // Mặc định khi thêm sách là chưa mượn
    }

    // Getters và Setters
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

    // ✅ Thao tác mượn sách
    public void muonSach() {
        this.borrowed = true;
    }

    // ✅ Thao tác trả sách
    public void traSach() {
        this.borrowed = false;
    }

    // ✅ In ra để debug/log dễ dàng
    @Override
    public String toString() {
        return "[" + id + "] " + title + " - " + author + " (" + viTri + ") - " + (borrowed ? "Đã mượn" : "Có sẵn");
    }
}
