public class KnapsackWithoutRepetitions {
    private static int max(int a, int b) {
        return (a>b)?a:b;
    }
    private static int maxValue(int capacity, int[] weights, int[] values, int n) {
        int[][] mv = new int[capacity+1][n+1];
        for(int i=0;i<=n;i++) {
            for(int w=0;w<=capacity;w++) {
                if(i==0 || w==0) mv[w][i] = 0;
                else if(weights[i-1]<=w) {
                        mv[w][i] = max(values[i-1] + mv[w-weights[i-1]][i-1], mv[w][i-1]);
                    }
                    else mv[w][i] = mv[w][i-1];
                }
            }
        return mv[capacity][n];
    }
    public static void main(String[] args) {
        int capacity = 50;
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        System.out.println(maxValue(capacity, weights, values, weights.length));
    }
}
