package Sorting;

import java.util.Random;

public class Sorting {

    private static void print(int[] array) {
        for(int i : array) {
            System.out.println(i);
        }
    }

    private static void swap(int[] array, int pos1, int pos2) {
        int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }

    //Select smallest element and put in the first position, next smallest in the second position and so on....
    private static void selectionSort(int[] array) {
        for(int i=0;i<array.length;i++) {
            int min = i;
            for(int j=i+1;j<array.length;j++) {
                if(array[j]<array[min]) min = j;
            }
            swap(array, i, min);
        }
    }


    //create a sorted subarray and keep adding the elements in it in the right order
    private static void insertionSort(int[] array) {
        for(int i=1;i<array.length;i++) {
            int temp = array[i];
            int j;
            for(j=i;j>0;j--) {
                if(array[j-1]<temp) break;
                array[j] = array[j-1];
            }
            array[j] = temp;
        }
    }


    //bubble the largest element to the end and then the second largest element and so on
    private static void bubbleSort(int[] array) {
        for(int i=array.length-1;i>=0;i--) {
            for(int j=0;j<i-1;j++) {
                if(array[j]>array[j+1]) swap(array, j, j+1);
            }
        }
    }

    private static void merge(int[]arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];

        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    //Divide and Conquer approach, split the array into half and recursively split, then ,merge the subsequent halves
    private static void mergeSort(int[] arr, int l, int r) {
       if(l<r) {
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }


    private static int partition(int[] array, int l, int r) {
        Random rand = new Random();
        int randomNum = rand.nextInt((r - l) + 1) + l;
        swap(array, l, randomNum);
        int pivotElement = array[l];
        int j = l;
        for(int i = l+1;i<=r;i++) {
            if(array[i]<=pivotElement) {
                j=j+1;
                swap(array, i, j);
            }
        }
        swap(array, l, j);
        return j;
    }

    //Divide and conquer, find the pivot, put it in right place and call the routine on remaining sides
    private static void quickSort(int[] array, int l, int r) {
        if(l<r) {
            int pivot = partition(array, l, r);
            if(pivot-l < r-pivot) {
                quickSort(array, l, pivot-1);
                l=pivot+1;
            }
            else {
                quickSort(array, pivot+1, r);
                r = pivot-1;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 1, 8, 2, 7, 3, 6, 4, 5, 10};
        quickSort(array, 0, array.length-1);
        print(array);
    }
}
