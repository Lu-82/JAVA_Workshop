package Exercise;

class MathUtil {
    static int add(int a, int b){
        return a + b;
    }
    void num() { System.out.println("instance woof");}
}
public class Static_method {
    public static void main (String... var) {
        int s = MathUtil.add(3,4);
        System.out.println(" ");
        System.out.println(s);
        
        MathUtil m = new MathUtil();
        m.num();
    }
}
