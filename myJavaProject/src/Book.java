// Book.java
public class Book {
    public String masach;
    public String tensach;
    public String tacgia;
    public boolean trangthaiMuon;
    public String vitri;

    public Book(String masach, String tensach, String tacgia, String vitri) {
        this.masach = masach;
        this.tensach = tensach;
        this.tacgia = tacgia;
        this.vitri = vitri;
        this.trangthaiMuon = false;
    }

    public void muonsach() {
        trangthaiMuon = true;
    }

    public void trasach() {
        trangthaiMuon = false;
    }

    public void displayInfo() {
        String trangthai = trangthaiMuon ? "\u0110\u00e3 \u0111\u01b0\u1ee3c m\u01b0\u1ee3n" : "C\u00f3 s\u1eb5n";
        System.out.println("[" + masach + "] " + tensach + " - " + tacgia + " - " + vitri + " - " + trangthai);
    }

    public String getTenSach() { return tensach; }
    public boolean isMuon() { return trangthaiMuon; }
}
