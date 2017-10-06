package Week3;
import java.util.*;

public class DotProduct {
    private static long maxDotProduct(long[] a, long[] b) {
        // sort a and sort b in descending order
        for(int i=0;i<a.length-1;i++) {
            for(int j=0;j<a.length-i-1;j++){
                if(a[j]<a[j+1]) {
                    long temp = a[j];
                    a[j]=a[j+1];
                    a[j+1] = temp;
                }
                if(b[j]<b[j+1]) {
                    long temp1 = b[j];
                    b[j]=b[j+1];
                    b[j+1] = temp1;
                }
            }
        }

        long result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextLong();
        }
        System.out.println(maxDotProduct(a, b));
    }
}
