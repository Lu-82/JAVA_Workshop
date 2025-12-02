package DSA.LinearSearch;
import java.util.*;
public class Max2DArray {
    public static void main(String[] args) {
        int[][] arr = {
            {34,55,64,64,33},
            {35,66,3},
            {89,14,90,55},
            {3,66,97,12,57,33,87,}
        };
        
        int[] max = search(arr);
        System.out.println(Arrays.toString(max));
    }
    static int[] search(int[][] arr){
        int num = arr[0][0];
        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = 1; j < arr[i].length; j++) {
        //         if(arr[i][j] > num) {
        //             num =arr[i][j];
        //         }
        //     }
        // }
        for(int[] ints1:arr){
            for(int ints2:ints1){
                if(ints2>num){
                    num = ints2;
                }
            }
        }
        return new int[] {num};
    }
}
