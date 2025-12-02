package Exercise;

public class Exercise1 {
    public static void main(String[] args) {
        int[] arr = { 20, 15, 10, 7, 4, 2, 1 };
        int target = 17;
        System.out.println(searchInsert(arr, target));
    }

    static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target) // Notice the '<' here for descending
                end = mid - 1;
            else
                start = mid + 1;
        }

        return start;
    }

}
