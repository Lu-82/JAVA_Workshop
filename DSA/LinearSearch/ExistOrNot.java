package DSA.LinearSearch;

import java.util.*;

public class ExistOrNot {
    public static void main(String[] args) {
        int[] arr = { 23, 53, 66, 33, 86, 32, 89, 12, 29, 61, 46, 90 };
        try (Scanner input = new Scanner(System.in)) {
            // System.out.println("Enter array elements");
            // // input array
            // for (int i = 0; i < arr.length; i++) {
            // arr[i] = input.nextInt();
            // }
            // // output array
            // System.out.println(Arrays.toString(arr));

            // to find element
            System.out.println("Enter the element that you want to search");
            int search = input.nextInt();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == search) {
                    System.out.println(search + " is found in array in the " + i + " index");
                    break;
                }

            }
            

        }

    }

}
