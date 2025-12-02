package Pattern;

public class Pattern_1 {
    public static void main(String[] args) {
        System.out.println();
        start(4);
    }

    static void start(int n) {
        for(int row = 1; row <= n; row++){
            for(int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
