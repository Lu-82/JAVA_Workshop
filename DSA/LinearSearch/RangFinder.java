package DSA.LinearSearch;

import java.util.*;

public class RangFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = { 23, 54, 66, 43, 77, 9, 12, 20, 30 };
        int num = 43;
        System.out.println("Enter the range ( 0 to " + (arr.length - 1) + " ):");

        int start = input.nextInt();
        int end = input.nextInt();

        if (start < 0 || end > arr.length-1 || start > end) {
            System.out.println("Invalid ragne. please enter valid start and edn indices.");
        } else {

            search(arr, num, start, end);
        }
        input.close();
    }

    static void search(int[] arr, int target, int start, int end) {
        boolean found = false;
        for (int index = start; index < end; index++) {
            if (arr[index] == target) {
                System.out.println(target + " is found between " + start + " and " + end + " at the index " + index);
                found = true;
                break;
            }
        }
        if (!found)
            System.out.println(target + " is not found in array");
    }
}
