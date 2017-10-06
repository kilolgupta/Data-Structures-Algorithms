package Week2;

import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long lastDigitOfSum = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous%10 + current%10;
            lastDigitOfSum = lastDigitOfSum%10 + current%10;
        }
        return lastDigitOfSum%10;
    }
    private static void eff_calc_fib(int n, int[] arr) {
            long a = 0;
            long b = 1;
            arr[0]=(int)a;
            arr[1]=(int)b;
            long c;
            for (int i = 2; i <= n; i++) {
                c = a+b;
                a=b;
                b=c;
                arr[i]=(int)(c%10);
            }
        }

    private  static int sum(int n, int[] array) {
        int sum=0;
        for(int i=0;i<=n;i++)
            sum+=array[i];
        return sum;
    }
    private static long SumUnitDigitOfFib(long n) {
        int[] array = new int[60];
        eff_calc_fib(59, array);
        long k = n/60;
        int x = (int)(n%60);
        return ((sum(59, array)*k) + sum(x, array))%10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = SumUnitDigitOfFib(n);
        System.out.println(s);
    }
}

