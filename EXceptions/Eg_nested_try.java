package EXceptions;

public class Eg_nested_try {
    public static void main(String... var){
        try {
            int a = 2, b = 4, c = 2, x = 7, z;
            int p[] = {2};
             p[3] = 33;
             try {
                z = x/((b*b) - (4*a*c));
                System.out.println("The value of z is =" +z);
             } catch (ArithmeticException e) {
                System.out.println("Division by zero in Arithmetic expression");
             }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index is");
        }
    }
}
