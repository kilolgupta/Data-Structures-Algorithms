package Week3;
import java.text.DecimalFormat;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        while(capacity!=0) {
            int max_index = 0;
            for(int i=1; i<values.length;i++) {
                if(weights[i]>0) {
                    if((double)values[i]/(double)weights[i] > (double)values[max_index]/(double)weights[max_index]){
                        max_index=i;
                    }
                }
            }
            double minWeight = (capacity>weights[max_index])?weights[max_index]:capacity;
            value += minWeight*((double)values[max_index]/(double)weights[max_index]);
            capacity -= minWeight;
            values[max_index] = 0;
        }
        DecimalFormat twoDForm = new DecimalFormat("#.####");
        value = Double.valueOf(twoDForm.format(value));
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //number of items
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}

