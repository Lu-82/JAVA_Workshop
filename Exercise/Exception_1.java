package Exercise;
//import java.lang.*;
import java.io.*;

class userException extends Exception{
    userException(String msg){
        super(msg);
    }
}

public class Exception_1 {
    public static void main (String... var){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.println("Enter first string: ");
            String s1 = br.readLine();
            System.out.println("Enter second string: ");
            String s2 = br.readLine();
            if(s1.equals(s2)){
                System.out.println("Both string are equals");
            }
            else{
                throw new userException("String mismatch exception");
            }
        }
        catch(userException e){
            System.out.println(e);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
