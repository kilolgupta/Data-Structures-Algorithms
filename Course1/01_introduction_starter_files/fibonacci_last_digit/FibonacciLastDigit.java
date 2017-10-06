import java.util.*;

public class FibonacciLastDigit {
    private static long getFibonacciLastDigitNaive(long n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous%10 + current%10;
        }

        return current % 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}