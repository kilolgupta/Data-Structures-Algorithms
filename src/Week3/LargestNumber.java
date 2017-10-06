package Week3;
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



//        for(int i=0;i<a.length-1;i++) {
//            for(int j=0;j<a.length-i-1; j++){
//                if(((int) a[j].charAt(0)) < ((int) a[j+1].charAt(0))) {
//                    String temp = a[j];
//                    a[j] = a[j+1];
//                    a[j+1] = temp;
//                }
//                else if(((int) a[j].charAt(0)) == ((int) a[j+1].charAt(0))) {
//                   if((a[j].length() == a[j+1].length()) && Integer.parseInt(a[j]) < Integer.parseInt(a[j+1])) {
//                       String temp = a[j];
//                       a[j] = a[j+1];
//                       a[j+1] = temp;
//                   }
//                   else if((a[j].length() != a[j+1].length())) {
//                       int minLength = (a[j].length() < a[j+1].length()) ? a[j].length() : a[j+1].length();
//                       String number1 = "", number2="";
//                        for(int k=0;k<minLength;k++) {
//                            number1 += a[j].charAt(k);
//                            number2 += a[j+1].charAt(k);
//                        }
//                        if(Integer.parseInt(number1) < Integer.parseInt(number2)) {
//                            String temp = a[j];
//                            a[j] = a[j+1];
//                            a[j+1] = temp;
//                        }
//                        else if(Integer.parseInt(number1) == Integer.parseInt(number2)) {
//                            if((a[j].length() < a[j+1].length()) && (int)a[j+1].charAt(minLength) > (int) a[j].charAt(0)) {
//                                String temp = a[j];
//                                a[j] = a[j+1];
//                                a[j+1] = temp;
//                            }
//                            else if((a[j].length() > a[j+1].length()) && (int)a[j].charAt(minLength) < (int) a[j+1].charAt(0)){
//                                String temp = a[j];
//                                a[j] = a[j+1];
//                                a[j+1] = temp;
//                            }
//                        }
//                   }
//                }
//            }
//        }
