package Pattern;

public class Pattern_3 {
    public static void main(String[] args) {
        System.out.println();
        start(5);
    }

    static void start(int n) {
        for(int row = 1; row <= n; row++) {
            for(int col = 1; col <= n-row+1; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
