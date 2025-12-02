package DSA.String1;

public class PlandromeManual {
    public static void main(String[] args) {
        String str = "madam";
        boolean isPalindrome = true;
        for(int i = 0; i < str.length() / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)){
                isPalindrome = false;
                break;
            }
        }

        if(isPalindrome) {
            System.out.println("Palindrome");
        } else {
            System.out.println("not a palindrome");
        }
    }
}
