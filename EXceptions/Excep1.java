package EXceptions;

public class Excep1 {
    public static void main(String[] args){
        System.out.println();
        try {
            int n = Integer.parseInt(args[0]);
            int n1 =Integer.parseInt(args[1]);
            int n2 = n = n1;
        } catch (ArithmeticException ex) {
            System.out.println("Arithmatic Exception block 1");
        }
        // } catch(ArithmeticException ex){
        //     System.out.println("Arithmetic Exception block 2");
        // }
    }
}


// java disallowe duplicate catch types 

