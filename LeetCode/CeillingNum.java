package LeetCode;

//The ceiling of a number is the least integer that is greater than or equal to the given number
public class CeillingNum {
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
        return start ;
    }
}
