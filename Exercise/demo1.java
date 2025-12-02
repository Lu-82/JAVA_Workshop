package Exercise;
public class demo1 {
    public static void main(String[] args) {
        int[][] arr = {
            {2,3,5,7,4},
            {1,4,7,87,6},
            {4,76,8,9}
        };
    for (int i = 0; i < arr.length; i++) {
        int sum = 0;
        for (int j = 0; j < arr[i].length; j++) {
            sum = sum + arr[i][j];

        }
        System.out.println(sum);
    }
    
    }
}
