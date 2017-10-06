package Week2;
import java.util.*;

import static Week2.GCD.gcd_rec;

public class LCM {
    private static long lcm_naive(int a, int b) {
        for (long l = 1; l <= (long) a * b; ++l)
            if (l % a == 0 && l % b == 0)
                return l;

        return (long) a * b;
    }

    private static long lcm_eff(long a, long b) {
        long gcd = gcd_rec(a, b);
        return (a*b)/gcd;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();

        System.out.println(lcm_eff(a, b));
    }
}
