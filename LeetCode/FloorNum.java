package LeetCode;

//The "floor" of a number is the largest integer that is less than or equal to that number
public class FloorNum {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10,13,16,18,20};
        int target = 12;
        System.out.println(check(arr,target));
    }
    static int check(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid] < target) {
                start = mid + 1 ;
            }else{
                end = mid - 1;
            }
            
        }
        return end ;
    }
}
