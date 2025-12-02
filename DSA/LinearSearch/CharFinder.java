package DSA.LinearSearch;

public class CharFinder {
    public static void main(String[] args) {
        String name = "Hlo how are you";
        char element = 'w';
        // System.out.println(name.toCharArray());
        // System.out.println(name.charAt(0));

       System.out.println(search(name,element));;

    }
    static boolean search(String str, char target){
        if(str.length() == 0) {
            return false;
        }
        for(int i=1; i<str.length(); i++) {
            if(target == str.charAt(i)) {
                System.out.println(target+" is found at the position "+i);
                return true;
            }
        }
        return false;
    }
    
}
