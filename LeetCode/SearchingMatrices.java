package LeetCode;

public class SearchingMatrices {
    public static void main(String[] args) {
        int[][] arr = {
            {23,53,55,64,3},
            {12,87,54,33,2},
            {44,23,41,51,68}
        };
        int target = 54;
       System.out.println(searching(arr,target)); 
    }

    
    static int searching(int[][] nums, int target){
        for(int i=0; i<nums.length; i++){
            for(int j=i; j<nums[i].length; j++){
                if(target == nums[i][j]){
                    return  nums[i][j];
                }           
            }
        } 
        return -1;
    }
    
}
