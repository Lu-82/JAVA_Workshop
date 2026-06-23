package GFG.DSA.Array;

import java.util.Arrays;

public class Second_Largest {
    public static void main(String[] args) {
        int[] arr = { 12, 35, 1, 10, 34, 1 };
        System.out.println(check(arr));
    }

    public static int check(int[] arr){
        int n = arr.length;

        Arrays.sort(arr);

        for(int i = n-2; i >= 0; i--) {
            if(arr[i] != arr[n-1]){
                return arr[i];
            }
        }
        return -1;
    }
}
