package DSA.LinearSearch;

public class DigitChecker {
    public static void main(String[] args) {
        int[] arr = { 2134, 55655, 33, 516, 4354, 968, 827, 5, 124, 3330, 45 };
        countEvenDigits(arr);
    }

    static void countEvenDigits(int[] arr) {
        int count = 0;
        // for (int index = 0; index < arr.length; index++) {

        //     if (CountDigits(arr[index]) % 2 == 0) {
        //         count++;
        //     }
        // }
        for (int iterable_element : arr) {
            if(CountDigits1(iterable_element) % 2 == 0)
            count++;
        }
        System.out.println("Total number of numbers with even digit " + count);
    }

    static int CountDigits(int num) {
        // int digit = 0;
        // if (num == 0)
        //     return 1;
        // while (num > 0) {
        //     digit++;
        //     num = num / 10;
        // }
        String value = Integer.toString(num);
        int digit = value.length();
        return digit;
    }
    static int CountDigits1(int num) {
        // int digit = 0;
        // if (num == 0)
        //     return 1;
        // while (num > 0) {
        //     digit++;
        //     num = num / 10;
        // }
        String value = Integer.toString(num);
        int digit = value.length();
        return digit;
    }
}
