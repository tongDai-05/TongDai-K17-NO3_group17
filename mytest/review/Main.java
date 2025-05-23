package mytest.review;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GiaiThua gt = new GiaiThua();

        System.out.print("Nhập số nguyên n để tính giai thừa: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Không thể tính giai thừa cho số âm.");
        } else {
            // Bắt đầu đo thời gian
            long startTime = System.nanoTime();

            int ketQua = gt.tinhGiaiThua(n);

            // Kết thúc đo thời gian
            long endTime = System.nanoTime();
            long duration = endTime - startTime; // thời gian thực thi (nano giây)

            System.out.println("Giai thừa của " + n + " là: " + ketQua);
            System.out.println("Thời gian thực thi: " + duration + " nanoseconds");
        }

        scanner.close();
    }
}
