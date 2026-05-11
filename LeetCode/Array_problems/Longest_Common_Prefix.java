package LeetCode.Array_problems;

public class Longest_Common_Prefix {
    public static void main(String... var) {
        System.out.println("");
        String[] str = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(str));
    }

    public static String longestCommonPrefix(String[] str) {
        for(int i = 0; i<str.length; i++){
            for(int j = i+1; j<str.length; j++){
                if(str[i].compareTo(str[j]) > 0){
                    String temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }
        String str1 = str[0];
        String str2 = str[str.length-1];
        int i = 0;
        while(i < str1.length()){
            if(str1.charAt(i) == str2.charAt(i) ){
                i++;
            }else{
                break;
            }
            
        }
        return str1.substring(0,i);
    }
}
