package Exercise;

//import java.lang.*;
import java.util.*;

@SuppressWarnings("unused")
class Thread1 extends Thread {
    public void run() {
        for(int i=1; i<=5; i++){
            // if(i==1)
            //     yield();
            // else 
                System.out.println("Thread1: "+i);
            
        }
    }
}

class Thread2 extends Thread {
    @SuppressWarnings("removal")
    public void run() {
        for(int j=6; j<=10; j++) {
            if(j==7)
                stop();
            else
                System.out.println("Thread2: "+j);
        }
    }
}

class Thread3 extends Thread {
    public void run() {
        for(int k=11; k<=15; k++) {
            if(k==13){
                try{
                    sleep(1000);
                } catch(Exception e){

                }
            }else{
                System.out.println("Thread3:"+k);
            }
        }
    }
}
public class Demo_Threads {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        t1.start();

        Thread2 t2 = new Thread2();
        t2.start();

        Thread3 t3 = new Thread3();
        t3.start();
    }
}
