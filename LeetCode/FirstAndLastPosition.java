package LeetCode;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        int[] arr = {1,3,7,7,7,8,8,10};
        int target = 7;

        int start = search(arr,target,true);
        int end = search(arr,target,false);
        
        System.out.println("First occurrence: " + start);
        System.out.println("Last occurrence: " + end);

    }
    static int  search(int[] arr, int target, boolean findStartIndex ) {
        int start = 0;
        int end = arr.length-1;
        int ans = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(target < arr[mid]) {
                end = mid - 1;

            }else if(target > arr[mid]){
                start = mid + 1;
            }else{
                ans = mid;
                if(findStartIndex){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }

        }
        return ans;
    }
}
