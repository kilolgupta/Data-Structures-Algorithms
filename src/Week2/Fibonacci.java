package Week2;
import java.util.Scanner;

public class Fibonacci {
//    private static long calc_fib(int n) {
//        if (n <= 1)
//            return n;
//
//        return calc_fib(n - 1) + calc_fib(n - 2);
//    }
    public static long eff_calc_fib(int n) {
        if(n<=1) return n;
        else {
            long a = 0;
            long b = 1;
            long c=0;
            for (int i = 2; i <= n; i++) {
                c = a+b;
                a=b;
                b=c;
            }
            return c;
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(eff_calc_fib(n));
    }
}
