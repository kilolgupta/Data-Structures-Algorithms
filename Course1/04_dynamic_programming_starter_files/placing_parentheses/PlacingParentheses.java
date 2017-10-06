import java.util.Arrays;
import java.util.Scanner;

public class PlacingParentheses {
    private static int n;
    private static long[][] min;
    private static long[][] max;
    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }
    private static long[][] minAndMax(int i, int j, char[] ops, long[] digits) {
        long minValue = Long.MAX_VALUE;
        long maxValue = Long.MIN_VALUE;
        long[][] minMax = new long[1][2];
        if(i==j) {
            minMax[0][0] = digits[i];
            minMax[0][1] = digits[i];
            return minMax;
        }
        else {
            for (int k = i; k <= j - 1; k++) {
                long a = eval(min[i][k], min[k+1][j], ops[k]);
                long b = eval(min[i][k], max[k+1][j], ops[k]);
                long c = eval(max[i][k], min[k+1][j], ops[k]);
                long d = eval(max[i][k], max[k+1][j], ops[k]);
                long[] values1 = {minValue, a, b, c, d};
                Arrays.sort(values1);
                minValue = values1[0];
                long[] values2 = {maxValue, a, b, c, d};
                Arrays.sort(values2);
                maxValue = values2[values2.length-1];
            }
            minMax[0][0] = minValue;
            minMax[0][1] = maxValue;
        }
        return minMax;
    }
    private static long getMaximValue(String exp) {
        long[] digits = new long[(exp.length()+1)/2];
        char[] ops = new char[(exp.length()-1)/2];
        int i=0, j=0;
        int d=0, op=1;
        while(d<exp.length()) {
            digits[i++] =  Character.getNumericValue(exp.charAt(d));
            d+=2;
            if(d!=exp.length()-1) {
                ops[j++] = exp.charAt(op);
                op += 2;
            }
        }
        n=digits.length;
        min = new long[n][n];
        max = new long[n][n];
        for(int p=0;p<n;p++) {
            min[p][p] = digits[p];
            max[p][p] = digits[p];
        }
        for(int s = 1; s<=n-1;s++) {
            for(int t = 0;t<n-s;t++) {
                int r = t+s;
                min[t][r] = minAndMax(t, r, ops, digits)[0][0];
                max[t][r] = minAndMax(t, r, ops, digits)[0][1];
            }
        }

        return max[0][n-1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        if(exp.length()==1) System.out.println(exp);
        else {
            System.out.println(getMaximValue(exp));
        }
    }
}