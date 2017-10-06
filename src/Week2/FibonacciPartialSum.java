package Week2;

import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        if (to <= 1)
            return to;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < from - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous%10 + current%10;
        }

        long lastDigitOfSum = current%10;

        for (long i = 0; i < to - from; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous%10 + current%10;
            lastDigitOfSum += current%10;
        }

        return lastDigitOfSum % 10;
    }
    private static void eff_calc_fib(int n, int[] arr) {
        long a = 0;
        long b = 1;
        arr[0]=(int)a;
        arr[1]=(int)b;
        long c=0;
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
    private static int getFibonacciPartialSum(long from, long to) {
        long temp1 = SumUnitDigitOfFib(to);
        long temp2 = SumUnitDigitOfFib(from-1);
        if(temp1<temp2) return (int)(temp1+10 - temp2);
        else return (int)(temp1-temp2);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSum(from, to));
    }
}


