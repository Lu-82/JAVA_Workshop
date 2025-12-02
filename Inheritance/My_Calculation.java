package Inheritance;

class Calulation {
    int z;
    public void addition(int x, int y){
        z = x + y;
        System.out.println("the sum of the given numbers:"+z);
    }
    public void substraction(int x, int y){
        z = x - y;
        System.out.println("the difference between the given nubers:"+z);
    }
}
public class My_Calculation extends Calulation {
    public void multiplication(int x, int y) {
         z = x * y;
        System.out.println("The product of the given nubers: "+z);
    }

    public static void main(String... var){
        int a = 20, b = 10;
        My_Calculation demo = new My_Calculation();
        demo.addition(a,b);
        demo.substraction(a, b);
        demo.multiplication(a, b);
    }
}
