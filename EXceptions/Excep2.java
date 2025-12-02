package EXceptions;

public class Excep2 {
    public static void main(String[] args) {
        System.out.println();
        try{
            int n = Integer.parseInt(args[0]);
            int n1 = Integer.parseInt(args[1]);
            int n2 = n + n1;
            System.out.println("sum is " + n2);
        }catch(ArithmeticException ex) {
            System.out.println("Arithmetic Exception :"+ex.getMessage());
        }catch(NumberFormatException ex){
            System.out.println("Format Excaption : "+ex.getMessage());
        }catch(Exception ex) {
            System.out.println("Exception:"+ex);
        }
    }
}
