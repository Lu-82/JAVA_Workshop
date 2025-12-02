package DSA.Sorting;

public class Selection {

    public static void main(String[] args) {
        int[] arr = {8,6,1,5,9,3};
        System.out.println("unsorted array");
        printArray(arr);
        selectionSort(arr);
        System.out.println("sorted array");
        printArray(arr);
    }
    static void printArray(int[] arr){
        for(int val:arr){
            System.out.println(val+ " ");
        }
        System.out.println();
    }

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int max_indx = i;
            for(int j = i+1; j<arr.length; j++) {
                if(arr[j] < arr[max_indx]){
                    max_indx = j;
                }
            }
           int tem = arr[i];
           arr[i] = arr[max_indx];
           arr[max_indx] = tem;
        }
        
    }
}