import java.util.Scanner;

public class PointsAndSegments {
    static void merge(int arr[], int arr2[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int [n1];
        int R[] = new int [n2];
        int L1[] = new int [n1];
        int R2[] = new int [n2];
        for (int i=0; i<n1; ++i) {
            L[i] = arr[l + i];
            L1[i] = arr2[l+i];
        }
        for (int j=0; j<n2; ++j) {
            R[j] = arr[m + 1+ j];
            R2[j] = arr2[m + 1+ j];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                arr2[k] = L1[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                arr2[k] = R2[j];
                j++;
            }
            k++;
        }
        while (i < n1)
        {
            arr[k] = L[i];
            arr2[k] = L1[i];
            i++;
            k++;
        }
        while (j < n2)
        {
            arr[k] = R[j];
            arr2[k] = R2[j];
            j++;
            k++;
        }
    }
    static void sort(int arr[], int arr2[], int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;
            sort(arr, arr2, l, m);
            sort(arr , arr2, m+1, r);
            merge(arr, arr2, l, m, r);
        }
    }
    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        //sort the ranges based on starting point
        sort(starts, ends, 0, starts.length-1);

        for(int p=0;p<points.length;p++) {
            for(int k=0;k<starts.length;k++) {
                if(points[p]>=starts[k] && points[p]<=ends[k]) cnt[p]++;
                if(k<starts.length-1) {
                    if(starts[k+1]>ends[k])
                        break;
                }
            }
        }
        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}