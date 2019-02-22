package Base;

public class Powxn {
    public double myPow(double x, int n) {
        if(n<0){
            x = 1/x;
            if(n==Integer.MIN_VALUE){
                return  x*myPow(x,-(n+1));
            }
            n = -n;
        }
        if(n == 0){
            return 1;
        }else{
            return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
        }
    }

    public static void main(String[] args) {
        Powxn powxn = new Powxn();
        System.out.println(powxn.myPow(2,5));
    }
}
