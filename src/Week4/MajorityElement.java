package Week4;
import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int findCandidate(int[] a) {
        int maj_index = 0;
        int candidate = a[maj_index];
        int count =1 ;
        for(int i=1;i<a.length;i++) {
            if(a[i]==a[maj_index]) count++;
            else count--;
            if(count==0) {
                maj_index = i;
                count = 1;
            }
        }
        return a[maj_index];
    }
    private static int checkForMajority(int[] a) {
        int candidate = findCandidate(a);
        int count =0;
        for(int num: a) {
            if(num==candidate) count++;
        }
        if(count>(a.length/2)) return 1;
        else return 0;
    }
    private static int getMajorityElement(int[] a, int left, int right) {
        if(right==-1) return -1;
        if (left == right) {
            return a[left];
        }
        //write your code here
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(checkForMajority(a));
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}


