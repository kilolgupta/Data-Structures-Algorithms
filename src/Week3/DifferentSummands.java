package Week3;
import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int i=1;
        int index = 0;
        while(n>0) {
            if((n-i)>= i+1) {
                summands.add(index++, i);
                n -= i;
                i++;
            }
            else {
                summands.add(index, n);
                break;
            }
        }
        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        if(summands!=null) {
            System.out.println(summands.size());
            for (Integer summand : summands) {
                System.out.print(summand + " ");
            }
        }
    }
}