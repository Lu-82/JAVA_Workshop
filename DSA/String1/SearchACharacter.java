package DSA.String1;

public class SearchACharacter {
    public static void main(String[] args) {
        String s = "IAmACoder";
        char ch = 'C';
        System.out.println(search(s, ch));
    }
    static int search(String s,char ch) {
        
        for(int i = 0 ; i < s.length(); i++ ){
            if(s.charAt(i) == ch){
               return i;
            }
        }  
        return -1;
    }
}
