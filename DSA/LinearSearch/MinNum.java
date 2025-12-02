package DSA.LinearSearch;
// import java.util.*;
public class MinNum {
    public static void main(String[] args) {
        int[] arr = {23,54,66,1,87,12,5,90,53,33,4};
        System.out.println(minFounder(arr));
    }
    static int minFounder(int[] arr){
        int min = arr[0];
        // boolean result = false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min; 
    }
}
