package qli_thuvien.src;
import java.util.ArrayList;
import java.time.LocalDate;

public class UserBook{
    ArrayList<Book> list= new ArrayList<Book>(); // them danh sach
    ArrayList<LoanRecord> dsm= new ArrayList<>(); // danh sach ban ghi muon

    public ArrayList<Book> addBook(Book ub){
        list.add(ub);
        return list;
    }

// sua sach
    public ArrayList<Book> getEditBook(String masach,String tensach ){  
        for(int i=0; i < list.size(); i++){
            if(list.get(i).masach == masach){
                System.out.print("true");
                list.get(i).tensach= tensach; 
            }
            
        }
        return list;
    }
// xoa sach
    public ArrayList<Book> getDeleBook(String ms){
        for(int i=0; i< list.size(); i++){
            if(list.get(i).masach == ms){
            list.remove(i);
        }
      } return list;
    }

 // doc
public void printUserBook(){
    int len = list.size();
    for(int i=0; i< len; i++){
        System.out.println("[" +list.get(i).masach + "]" +list.get(i).tensach+ "-" + list.get(i).trangthaiMuon);
    }
 }

 //muonsach
    public void muonSach(String maSach, User user, LocalDate ngayMuon) {
        for (Book b : list) {
            if (b.masach.equals(maSach) && !b.trangthaiMuon) {
                b.muonsach();  // Đánh dấu là đã mượn
                LoanRecord record = new LoanRecord(b, user, ngayMuon);
                dsm.add(record);  // Thêm vào danh sách đã mượn
                System.out.println("[" + b.masach + "] đã được mượn bởi " + user.getName()+ " vào ngày " + ngayMuon);
                return;
            }
        }
        System.out.println("Khong tim thay sach hop le hoac sach da duoc muon.");
    }

    // Hiển thị danh sách sách được mượn theo ngày
    public void hienThiSachMuonTheoNgay(LocalDate ngay) {
        System.out.println("Danh sach duoc muon vao ngay: " + ngay);
        for (LoanRecord lr : dsm) {
            if (lr.getBorrowDate().equals(ngay)) {
                System.out.println("- " + lr.getBook().tensach + " (Nguoi muon: " + lr.getUser().getName() + ")");
            }
        }
    }


}
