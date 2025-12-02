package Array;

import java.util.Scanner;

//import java.util.Arrays;
public class Array_1 {
    public static void main(String[] args) {
        
    //     int[] arr = {12,34,2,55,32,556,22};
    //     getArray(arr);
        
    // }
    // static void getArray(Object arr ){
    //     if(arr instanceof int[])
    //         System.out.println(Arrays.toString((int[])arr));
    // int arr[] = m1();
    // for(int i = 0; i < arr.length; i++) {
    //     System.out.println(arr[i] + " ");
    // }
    // }
    // public static int[] m1() {
    //     return new int[]{1,2,3,4};
    System.out.println();
    Scanner in = new Scanner(System.in);
    int[] arr = new int[5];
    for (int i = 0; i < arr.length; i++) {
        //System.out.println("enter the element into arr");
        arr[i] = in.nextInt();
    }
    for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i]+" ");
    }
    for (int num : arr) {
        System.out.println(num+" ");
    }
    }
}
