package Sorting;

public class Selection {

    public static void selectionSort(int[] arr) {

        int n = arr.length;
        for(int i=0; i<n-1; i++) {
            int minIndex = i;
            for(int j=i+1; j<n; j++) {
                if(arr[j] < arr[i]) {
                    minIndex = j;
                }

                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }

        for(int i=0; i<n; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        int[] arr = {23,54,77,54,12,97,37};
        selectionSort(arr);
    }
}
