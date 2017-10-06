import java.util.Scanner;

public class CarRefuelling {
    private static int count=0;
    private static void minRefills(int[] x, int start, int L) {
        for(int i=start+1; i<x.length;i++) {
            if(x[i]-x[start]>L) {
                count++;
                System.out.println("Refill number: " + count + " at distance" + x[i-1]);
                minRefills(x, i-1, L);
                return;
            }
        }
    }
    public static void main(String[] args) {
        int[] x = new int[6];
        x[0] = 0;
        x[5] = 950;
        Scanner scanner = new Scanner(System.in);
        for(int i=1;i<=4;i++)
            x[i] = scanner.nextInt();

        int maxDistance = 400;
        minRefills(x, 0, maxDistance);
    }
}
