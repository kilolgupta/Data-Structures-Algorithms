public class FractionalKnapsack {
    private static int[][] max(int[][] weightValues) {
        int max=0;
        for(int i=1;i<weightValues.length;i++) {
            if(weightValues[max][1] < weightValues[i][1]) max=i;
        }
        int[][] maxWeightValue = new int[1][2];
        maxWeightValue[0][0] = weightValues[max][0];
        maxWeightValue[0][1] = weightValues[max][1];
        return maxWeightValue;
    }
    private static int maxValue(int capacity, int[][] weightValues) {
        int totalValue = 0;
        for(int i=0;i<weightValues.length;i++) {
            weightValues[i][1]/= weightValues[i][0];
        }

        while(capacity!=0) {
            int[][] maxWV = max(weightValues);
            if(maxWV[0][0] <= capacity) {
                totalValue += maxWV[0][0]*maxWV[0][1];
                capacity -= maxWV[0][0];
                System.out.println("Took " + maxWV[0][0] + " units of total value " + maxWV[0][0]*maxWV[0][1]);
            }
            else {
                totalValue += capacity*maxWV[0][1];
                System.out.println("Took " + capacity + " units of total value " + capacity*maxWV[0][1]);
                capacity = 0;
            }
            for(int i=0;i<weightValues.length;i++) {
                if(weightValues[i][0] == maxWV[0][0] && weightValues[i][1]==maxWV[0][1])
                    weightValues[i][1] = 0;
            }
        }
        return totalValue;
    }
    public static void main(String[] args){
        int capacity = 7;
        int[][] weightValues = {{4, 20}, {3, 18}, {2, 14}};
        System.out.println(maxValue(capacity, weightValues));
    }
}
