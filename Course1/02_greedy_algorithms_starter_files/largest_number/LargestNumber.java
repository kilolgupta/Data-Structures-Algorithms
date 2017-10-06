import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        String result = "";
        for(int i=0;i<a.length-1; i++) {
            for(int j=0;j<a.length-i-1;j++) {
                int num1 = Integer.parseInt(a[j] + a[j+1]);
                int num2 = Integer.parseInt(a[j+1] + a[j]);
                if(num1<num2) {
                    String temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        for(String number: a){
            result += number;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}