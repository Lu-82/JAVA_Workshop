package LeetCode.Array_problems.Two_pointer_Technique;

public class P_125 {
    public static void main(String[] args) {
        String str = "HeLlo@123 World!";
        str = str.toLowerCase().replaceAll("[^a-z0-9]","");
        // System.out.println(str); hello123world
        System.out.println(isPalindrome(str));
    }

     public static boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
       
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }
        return true;
    }
}
