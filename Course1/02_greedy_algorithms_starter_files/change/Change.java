import java.util.Scanner;
public class Change {
    private static int getChange(int m) {
        int tenCoins = m/10;
        m=m%10;
        int fiveCoins = m/5;
        int oneCoins = m%5;
        return tenCoins+fiveCoins+oneCoins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}