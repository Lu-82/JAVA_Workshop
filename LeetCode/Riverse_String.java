package LeetCode;


public class Riverse_String {
    public static void main(String... var) {
        System.out.println("");
        char[] s = { 'r', 'a', 'g', 'h', 'u', 'n', 'a', 't', 'h' };
        System.out.println("original stirng");
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i]+" ");
        }
        reverseString(s);
        // swap();
    }

    public static void reverseString(char[] s) {
        System.out.println("");
        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }

        System.out.println("Reverse string ");
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i]+" ");
        }
    }

}
