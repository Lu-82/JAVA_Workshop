package GFG.DSA.Array;

public class ArrayRotations {
    public static void main(String[] args) {
        int []arr = {1,4,3,2,6,5};
        int k = 3;
        rotateclockwise(arr,k);
        for(int num : arr) {
            System.out.print(num+" ");
        }
    }

    public static void rotateclockwise(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        reverse(arr, 0, n-1);
        reverse(arr, 0, k-1);
        reverse(arr, k, n-1);
    }

    public static void reverse(int[] arr, int left, int right) {
        while(left <= right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}
