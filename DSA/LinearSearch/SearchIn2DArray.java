package DSA.LinearSearch;

import java.util.*;

public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
            {23,65,77,33},
            {34,6,86},
            {12,88,55,34}
        };
        int target = 7;
        int[] ans = search(arr, target);
        System.out.println(Arrays.toString(ans));

        }
    

    static int[] search(int[][]nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if(nums[i][j] == target){
                    return new int[]{i,j};
                }
            }
            
        }
        return new int[]{-1,-1};
    }
}
