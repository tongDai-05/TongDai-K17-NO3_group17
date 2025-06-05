public class Book {
    public String masach;
    public String tensach;
    public String tacgia;
    public boolean trangthaiMuon;
    public String vitri;

    public Book(String masach, String tensach, String tacgia) {
        this.masach = masach;
        this.tensach = tensach;
        this.tacgia = tacgia;
        this.trangthaiMuon = false;
    }

    public void muonsach() {
        trangthaiMuon = true;
    }

    public void trasach() {
        trangthaiMuon = false;
    }

    public void displayInfo() {
        String trangthai = trangthaiMuon ? "Đã được mượn" : "Có sẵn";
        System.out.println("[" + masach + "] " + tensach + " - " + tacgia + " - " + trangthai);
    }
}
