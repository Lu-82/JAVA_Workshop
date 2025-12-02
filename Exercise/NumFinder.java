package Exercise;
// import java.util.*;

// public class NumFinder {
//     public static void main(String[] args) {
//         int count = 0;
//         int[] arr = { 12, 33, 43, 12, 22, 12, 56, 12, 30 };
//         try (Scanner input = new Scanner(System.in)) {

//             for (int i = 0; i < arr.length; i++) {
//                 System.out.println(arr[i]);
//             }
//             System.out.println("Enter the number whose repetition is to be found ");
//             int n = input.nextInt();
//             for (int i = 0; i < arr.length; i++) {
//                 if (arr[i] == n) {
//                     count++;
//                 }
//             }
//         }

//         System.out.println(count);
//     }
// }12

// ---------------------------------------------------------------------------------------------------------------------------
// import java.util.*;

// public class NumFinder {
//     public static void main(String[] args) {
//         int count = 0;
//         int[] arr = {12, 33, 43, 12, 22, 12, 56, 12, 30};

//         try (Scanner input = new Scanner(System.in)) {
//             System.out.println("Array elements: " + Arrays.toString(arr));  // Print in one line

//             System.out.print("Enter the number whose repetition is to be found: ");
//             int n = input.nextInt();

//             // Single loop for printing & counting occurrences
//             for (int num : arr) {
//                 if (num == n) {
//                     count++;
//                 }
//             }
//         }

//         System.out.println("Occurrences of " + count);
//     }
// }

// import java.util.*;

public class NumFinder {
    public static void main(String[] args) {

        int num = 3456643;
        int ans = 0;

        while(num > 0) {
            int rem = num % 10;
            num = num/10;
            ans = ans*10+rem;
        }
        System.out.println(ans);
    }
}