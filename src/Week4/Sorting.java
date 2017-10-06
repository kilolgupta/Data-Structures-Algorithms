package Week4;
import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
        int pivot = a[l];
        int lt = l, gt = r, i = l;
        while (i <= gt) {
            if (a[i] < pivot) {
                int temp = a[i];
                a[i] = a[lt];
                a[lt] = temp;
                lt++;
                i++;
            } else if (a[i] > pivot) {
                int temp1 = a[i];
                a[i] = a[gt];
                a[gt] = temp1;
                gt--;
            } else i++;
        }

        int m1 = lt;
        int m2 = gt;
        int[] m = {m1, m2};
        return m;
    }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        while(l<r) {
            int[] m = partition3(a, l, r);
            int m1 = m[0];
            int m2 = m[1];
            if(m1-l < r-m2) {
                randomizedQuickSort(a, l, m1-1);
                l=m2+1;
            }
            else {
                randomizedQuickSort(a, m2+1, r);
                r=m1-1;
            }
        }
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
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