import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class OrganiseChildren {
    private static ArrayList ages = new ArrayList<Float>();

    private static ArrayList<Float> createPartition(ArrayList<Float> ages) {
        ArrayList<Float> partition = new ArrayList<Float>();
        partition.add(0, ages.get(0));
        ages.remove(0);
        while(!ages.isEmpty()) {
            if(ages.get(0)-partition.get(0) <=1) {
                partition.add(ages.get(0));
                ages.remove(0);
            }
            else break;
        }

        return partition;
    }

    public  static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<5;i++)
            ages.add(i, scanner.nextFloat());

        Collections.sort(ages);
        while(!ages.isEmpty()) {
            ArrayList partition = createPartition(ages);
            System.out.println(partition.toString());
        }
    }
}

