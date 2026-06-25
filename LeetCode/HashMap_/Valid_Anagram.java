package LeetCode.HashMap_;

import java.util.HashMap;

public class Valid_Anagram {
    public static void main(String[] args) {
        String s = "anagram"; 
        String t = "nagaram";
        
        isAnagram(s,t);
    }

    public static boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> check = new HashMap<>();

        if(s.length() != t.length()) {
            return false;
        }

        for(char ch : s.toCharArray()) {
            check.put(ch,check.getOrDefault(ch, 0)+1);
        }

        for(char ch : t.toCharArray()) {
            if(!check.containsKey(ch)) {
                return false;
            }
            check.put(ch,check.get(ch)-1);
        }

        for(int value : check.values()) {
            if(value != 0) {
                return false;
            }
        }
        return true;
    }
}
