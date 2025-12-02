package Exercise;

public class NumForException {
    public static void main (String args[]) {
        //String s = "abc";
        //int i = Integer.parseInt(s);
        // int a = 5;
        // int b = 34;
        // int res = 0;
        // try {
        //     res = a / (b-10);
        // } catch (ArithmeticException e) {
        //     System.out.println("ArithmeticException caught");
        // }
        // finally{
        //     System.out.println("a = "+a);
        //     System.out.println("b = "+b);
        //     System.out.println("res = "+res);

        // }


        // try{
        //     int a = args.length;
        //     System.out.println("a = "+a);
        //     int b = 42 / a;
        //     int c[] = { 1 };
        //     c[42] = 99;
        // } catch(ArithmeticException e){
        //     System.out.println("Divide by 0: "+e);
        // } catch(ArrayIndexOutOfBoundsException e) {
        //     System.out.println("Array index oob: "+e);
        // }
        // System.out.println("After try/catch blocks.");

        int a = 5;
        int b = 10;
        int res = compute(a,b);
        System.out.println("a ="+a);   
        System.out.println("b ="+b);
        System.out.println("res ="+res);
    }
    static int compute(int a, int b) throws ArithmeticException {
        return(a/(b-10));
    }

}

