package mytest.review;

public class GiaiThua {
    public int tinhGiaiThua(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * tinhGiaiThua(n - 1);
        }
    }
}
