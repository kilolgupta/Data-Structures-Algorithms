import java.util.Random;

public class Sorting {
    private static void bubbleSort(int[] array) {
        int n= array.length;
        for(int i=0; i<n-1;i++) {
            for(int j=0;j<n-i-1;j++) {
                if(array[j+1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    private static void insertionSort(int[] array) {
        int n=array.length;
        for(int i=1;i<n;i++) {
            int key = array[i];
            int j = i-1;
            while(j>=0 && array[j] > key) {
                array[j+1] = array[j];
                j=j-1;
            }
            array[j+1] = key;
        }
    }
    private static void selectionSort(int[] array) {
        int n=array.length;
        for(int i=0;i<n;i++) {
            int minIndex = i;
            for(int j=i+1;j<n;j++) {
                if(array[j]<array[minIndex]) minIndex=j;
            }
            if(minIndex!=i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }
    private static int inversionCount = 0;
    private static void merge(int[] array, int l, int m, int h) {
        int n1 = m-l+1;
        int n2 = h-m;
        int[] a = new int[n1];
        int[] b = new int[n2];
        int r=0, s=0;
        for(int p=l;p<=m;p++) a[r++] = array[p];
        for(int q=m+1;q<=h;q++) b[s++] = array[q];

        int i=0, j=0, k=l;
        while(i<n1 && j<n2) {
            if(a[i]<=b[j]) array[k] = a[i++];
            else if(a[i]>b[j]){
                array[k] = b[j++];
                inversionCount++;
            }
           k++;
        }
        while(j<n2)
            array[k++] = b[j++];
        while(i<n1)
            array[k++] = a[i++];
    }
    private static void mergeSort(int[] array, int low, int high) {
       if(low < high) {
           int m = low + ((high-low)/2);
           mergeSort(array, low, m);
           mergeSort(array, m+1, high);
           merge(array, low, m, high);
       }
    }
    public static int[] countingSort(int[] array) {
        int[] sortedArray = new int[array.length];
        int[] count = new int[10];
        for(int j=0;j<10;j++) count[j] = 0;
        for(int i=0;i<array.length;i++) count[array[i]]++;
        for(int k=0, m=0;k<array.length;) {
            for(int c=1;c<=count[m];c++) {
                sortedArray[k++] = m;
            }
            m++;
        }
        return sortedArray;
    }
    private static int[] partition2(int[] array, int l, int r) {
        int[] m = new int[2];
        Random rand = new Random();
        int randomNum = rand.nextInt((r - l) + 1) + l;
        int x = array[randomNum];
        int tempNum = array[l];
        array[l] = array[randomNum];
        array[randomNum] = tempNum;
        int j=l;
        int k=l;
        for(int i = l+1;i<=r;i++) {
            if(array[i]<x) {
                if(array[j+1] == x) {
                    int smallNumber = array[i];
                    int index = i;
                    for(int s=1;s<i-j;s++) {
                        int shifting = array[index-1];
                        array[index] = shifting;
                        index--;
                    }
                    j=j+1;
                    array[j] = smallNumber;
                    k=k+1;
                }
                else {
                    j=j+1;
                    if(k<j)
                        k=j;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            else if(array[i]==x) {
                k=k+1;
                int tem = array[i];
                array[i] = array[k];
                array[k] = tem;
            }
        }
        int temp1 = array[j];
        array[j] = array[l];
        array[l] = temp1;
        m[0]=j;
        m[1]=k;
        return m;
    }
    private static int partition(int[] array, int l, int r) {
        Random rand = new Random();
        int randomNum = rand.nextInt((r - l) + 1) + l;
        int x = array[randomNum];
        int tempNum = array[l];
        array[l] = array[randomNum];
        array[randomNum] = tempNum;
        int j=l;
        for(int i = l+1;i<=r;i++) {
            if(array[i]<=x) {
                j=j+1;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp1 = array[j];
        array[j] = array[l];
        array[l] = temp1;
        return j;
    }
    private static void quickSort2(int[] array, int l, int r) {
        while(l<r) {
            int m1 = partition2(array, l, r)[0];
            int m2 = partition2(array, l, r)[1];
            if(m1-l < r-2) {
                quickSort2(array, l, m1-1);
                l=m2+1;
            }
            else {
                quickSort2(array, m2+1, r);
                r=m1-1;
            }
        }
    }
    private static void quickSort(int[] array, int l, int r) {
        while(l<r) {
            int m = partition(array, l, r);
            if(m-l < r-m) {
            quickSort(array, l, m-1);
            l=m+1;
            }
            else {
                quickSort(array, m+1, r);
                r=m-1;
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {9, 5, 7, 3, 4, 10, 8, 6, 1, 9, 8, 2};
       //  bubbleSort(array);
        //insertionSort(array);
        //selectionSort(array);
        //mergeSort(array, 0, array.length-1);
       quickSort(array, 0, array.length-1);
       // int[] arrayWithSmallIntegers = {3, 2, 1, 0, 5, 3, 6, 7, 1, 1, 0, 5};
      //  int[] sortedArray = countingSort(arrayWithSmallIntegers);
        for(int num:array) {
            System.out.println(num);
        }
    }
}
