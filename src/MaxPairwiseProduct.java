import java.util.*;
        import java.io.*;

public class MaxPairwiseProduct {
    static long maxPairwiseProductFast(int[] numbers) {
        int n = numbers.length;
        int maxIndex1 = -1;
        for(int i=0;i<n;i++) {
            if(maxIndex1==-1) maxIndex1 = i;
            else if(numbers[maxIndex1] < numbers[i])
                maxIndex1 = i; // 2
        }
        int maxIndex2 = -1;
        for(int j=0;j<n;j++) {
            if((j!=maxIndex1)&&(maxIndex2==-1)) maxIndex2 = j;
            else if((j!=maxIndex1)&&(numbers[maxIndex2] < numbers[j]))
                maxIndex2 = j;
        }
        return (long)numbers[maxIndex1]*numbers[maxIndex2];
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(maxPairwiseProductFast(numbers));
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