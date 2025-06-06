public class Giaithua {
    public static long Gt(int n){
        if(n==0||n==1) return 1;
        else
            return n*Gt(n-1);
    }
}