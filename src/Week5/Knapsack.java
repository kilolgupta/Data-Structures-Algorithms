package Week5;

import java.util.*;

public class Knapsack {
    private static int max(int a, int b) {
        return (a>b)?a:b;
    }
    private static int optimalWeight(int W, int[] w) {
        //write you code here
        int[][] maxValue = new int[W+1][w.length+1];
        for(int i=0;i<=W;i++) {
            for(int j=0;j<=w.length;j++) {
                if(i==0 || j==0) maxValue[i][j] = 0;
                else if(w[j-1]<=i) {
                    maxValue[i][j] = max(w[j-1] + maxValue[i-w[j-1]][j-1], maxValue[i][j-1]);
                }
                else maxValue[i][j] = maxValue[i][j-1];
            }
        }
        return maxValue[W][w.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}