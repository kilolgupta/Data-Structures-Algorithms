import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }
    private static ArrayList<Integer> mods  = new ArrayList<>();
    private static long getPisanoPeriod(long m) {
        int a=0;
        int b=1;
        mods.add(0, a);
        mods.add(1, b);
        int c;
        int pisanoPeriod;
        for(int i=2;true;i++){
            c=(a+b)%(int)m;
            mods.add(i, c);
            a=b;
            b=c;
            if(a==0 && b==1)
            {
                pisanoPeriod = i-1;
                break;
            }
        }
        return pisanoPeriod;
    }
    private static long getFibonacciHugeModulo(long n, long m) {
        long temp = n%getPisanoPeriod(m);
        return mods.get((int)temp)%m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeModulo(n, m));
    }
}