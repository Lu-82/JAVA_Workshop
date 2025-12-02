package EXceptions;

class InvalidAgeException extends Exception {
    InvalidAgeException(String msg){
        super(msg);
    }
}
public class TestMyException {
    public static void main(String... var)throws InvalidAgeException{
        System.out.println();
        vote(13);
        // try {
        //     vote(13);
        // } catch (Exception e) {
        //     System.out.println(e);
        // }
    }
    static void vote(int age) throws InvalidAgeException{
        if(age < 18){
            throw new InvalidAgeException("not eligible bzs age is under 18");
        }
        else{
            System.out.println("eligible for voting");
        }
    }
}
