import java.util.*;
public class PrimitiveCalculator {
    private static void optimal_sequence(int n) {
        int[] predecessor = new int[n + 1];
        int[] minNumberOfSteps = new int[n + 1];
        minNumberOfSteps[0] = 0;
        minNumberOfSteps[1] = 0;
        predecessor[0] = 0;
        predecessor[1] = 0;
        for (int i = 2; i <= n; i++) {
            minNumberOfSteps[i] = minNumberOfSteps[i - 1] + 1;
            predecessor[i] = i-1;

            if (i % 3 == 0) {
                if (minNumberOfSteps[i / 3] < minNumberOfSteps[i]) {
                    minNumberOfSteps[i] = minNumberOfSteps[i / 3] + 1;
                    predecessor[i] = i/3;
                }
            }
            if (i % 2 == 0) {
                if (minNumberOfSteps[i / 2] < minNumberOfSteps[i]) {
                    minNumberOfSteps[i] = minNumberOfSteps[i / 2] + 1;
                    predecessor[i] = i/2;
                }
            }
        }
        System.out.println(minNumberOfSteps[n]);
        int val = n;
        List<Integer> sequence = new ArrayList<>();
        while(val>=1) {
            sequence.add(val);
            val = predecessor[val];
        }
        for(int j=sequence.size()-1;j>=0;j--) System.out.print(sequence.get(j) + " ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        optimal_sequence(n);
    }
}