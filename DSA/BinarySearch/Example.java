package DSA.BinarySearch;

public class Example {
    public static void main(String[] args) {
        // 0 1 2 3 4 5 6 7 8 9
        // int[] arr = { 2, 5, 6, 7, 89, 112, 456, 789, 990, 2224 };// 9
        int[] arr = { 98, 67, 54, 33, 31, 23, 12, 11, 5, 3 };// 9

        int target = 67;
        int ans = binarySearch(arr, target);
        System.out.println(ans);
    }

    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        boolean isAsc = arr[start] < arr[end];
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (isAsc) {

                if (target < arr[mid]) {
                    end = mid - 1;

                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;

                } else {
                    start = mid + 1;
                }
            }
            
        }
        return -1;
    }
}
