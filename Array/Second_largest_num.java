package Array;

public class Second_largest_num {
    public static void main(String[] args) {
        int[] arr = {12,43,44,76,40,65,11};
        find(arr);
    }
    static void find(int[] arr) {
        int maxi = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(maxi < arr[i]){
                maxi = arr[i];
            }
        }
        System.out.println(maxi);
    }
}
