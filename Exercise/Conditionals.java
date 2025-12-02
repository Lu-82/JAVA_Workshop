package Exercise;
import java.util.Scanner;

public class Conditionals {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Pleae enter three numbers");
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            // find larger value

            if (a > b && a > c) {
                System.out.println(a + " is greater than " + b + " and " + c + "");
            } else if (b > c) {
                System.out.println(b + " is greater than " + a + " and " + c + "");
            } else {
                System.out.println(c + " is greater than " + a + " and " + b + "");
            }
        }
    }
}
