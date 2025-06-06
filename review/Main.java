import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("nhap vao so nguyen duong");
        int n = sc.nextInt();
        if(n<0){
            System.out.println("vui long nhap lai n>0");
        }else{
            long kq= Giaithua.Gt(n);
            System.out.println(n + "!" + "=" +kq);
        }
        sc.close();
    }
}