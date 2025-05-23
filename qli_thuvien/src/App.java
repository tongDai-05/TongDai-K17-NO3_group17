package qli_thuvien.src;
import java.util.Scanner;

public class App{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int chon;
        do{
            System.out.println("------QUAN LY THU VIEN------");
            System.out.println("1. Hien thi thong tin sach");
            System.out.println("2. Muon sach");
            System.out.println("3. Tra sach");
            System.out.println("4. Tim kiem sach");
            System.out.println("0. Thoat khoi chuong trinh");

            chon=sc.nextInt();
            
            switch (chon) {
                case 1:
                    
                    break;
            
                default:
                    break;
            }
            
        }while(chon != 0);
       
    }
}