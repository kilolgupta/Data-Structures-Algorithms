import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }
  public static long gcd_rec(long a, long b) {
    if(a%b ==0) return b;
    else return gcd_rec(b, a%b);
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
