package DSA.String1;

public class TwoStringEqual {
    public static void main (String... var) {
        String name1 = "raghu";
        String name2 = "raghu";

        if(Compare(name1, name2)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        //System.out.println(Compare(name1,name2));
    }
    static boolean Compare(String name1, String name2){
        if(name1.length() != name2.length()){
            return false;
        }
        for(int i = 0; i < name1.length(); i++) {
            if (name1.charAt(i) != name2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
