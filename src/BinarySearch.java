public class BinarySearch {
    private static void binarySearch(int[] array, int num, int start, int end) {
        if(start <= end) {
            int mid=(start+end)/2;
            if(array[mid]==num) System.out.println(num + " found at index " + mid);
            else if(array[mid] < num) binarySearch(array, num, mid+1, end);
            else binarySearch(array, num, start, mid-1);
        }
        else {
            System.out.println(num + " should have been at index " + (start));
        }
    }
    public static void main(String[] args) {
        int[] array = {1, 3, 6, 8, 10, 12};
        int num=0;
        binarySearch(array, num, 0, array.length-1);
    }
}
