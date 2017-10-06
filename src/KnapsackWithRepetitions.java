public class KnapsackWithRepetitions {
    private static void knapsack(int[][] values, int capacity) {
        int numberOfValues = values.length;
        while(capacity>0) {
            int maxValue = 0, maxIndex = -1;
            for(int i=0;i<numberOfValues;i++) {
                if(values[i][0]<=capacity && values[i][1]>maxValue) {
                    maxValue = values[i][1];
                    maxIndex=i;
                }
            }
            if(maxIndex!=-1) {
                capacity = capacity - values[maxIndex][0];
                System.out.println("Adding item number: " + (maxIndex+1));
            }
        }
    }
    public static void main(String[] args) {
        int[][] values = {{10, 5}, {20, 10}, {50, 50}, {30, 80}, {5, 10}};
        int capacity = 100;
        knapsack(values, capacity);
    }
}
