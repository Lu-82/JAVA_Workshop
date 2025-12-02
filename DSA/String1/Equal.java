package DSA.String1;

public class Equal {
    public static void main(String... var) {
        // String s1 = new String ( "GeeksforGeeks");
        // String s2 = new String ( "GeeksforGeeks"); 
        // System.out.println(s1 == s2); // false


        // String s1 = "GeeksforGeeks";
        // String s2 = "GeeksforGeeks";
        // System.out.println(s1 == s2); // true


        String s1 = "hello";
        String s2 = new String("hello");
        System.out.println(s2.intern() == s1);
    }
}
