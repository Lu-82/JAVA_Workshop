package DSA.String1;

public class LenthOfAString {
    public static void main(String... var) {
        String s = "GeeksforGeeks";
        System.out.println(length(s));
        // char[] chars = s.toCharArray();
        // for (char character : chars) {
        //     System.out.print(character + " ");
        // }
    }

    static int length(String s) {
        int count = 0;
        for (char i : s.toCharArray()) {
            count++;
        }
        return count;
    }
}
