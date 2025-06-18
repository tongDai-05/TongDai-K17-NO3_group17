// Book.java

public class Book {
    // Thuộc tính
    public String masach;           // Mã sách
    public String tensach;          // Tên sách
    public String tacgia;           // Tác giả
    public boolean trangThaiMuon;   // Trạng thái mượn: true = đã mượn, false = có sẵn
    public String viTri;            // Vị trí sách trong thư viện

    // Constructor - Khởi tạo thông tin sách
    public Book(String masach, String tensach, String tacgia, String viTri) {
        this.masach = masach;
        this.tensach = tensach;
        this.tacgia = tacgia;
        this.viTri = viTri;
        this.trangThaiMuon = false; // Mặc định sách chưa được mượn
    }

    // Đánh dấu sách là đã mượn
    public void muonSach() {
        trangThaiMuon = true;
    }

    // Đánh dấu sách là đã trả
    public void traSach() {
        trangThaiMuon = false;
    }

    // Hiển thị thông tin sách
    public void displayInfo() {
        String trangThai = trangThaiMuon ? "Đã được mượn" : "Có sẵn";
        System.out.println("[" + masach + "] " + tensach + " - " + tacgia + " - " + viTri + " - " + trangThai);
    }

    // Getter - lấy tên sách
    public String getTenSach() {
        return tensach;
    }

    // Getter - kiểm tra sách có đang được mượn không
    public boolean isMuon() {
        return trangThaiMuon;
    }
}
