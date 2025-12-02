// package Exercise;

// class Thread1 extends Thread{
//     public void run() {
//         for(int i=0; i<=5; i++){
//             if(i == 3)
//                 stop();
//             else
//                 System.out.println("Thread1:"+i);
//         }
//     }
// }
// class Thread2 extends Thread{
//     public void run() {
//         for(int j=6; j<=10; j++){
//             if(j == 8){
//                 try{
//                     sleep(1000);
//                 }
//                 catch(Exception e){

//                 }
//             }
//         }
//     }
// }
// public class Thread_1 {
//     public static void main (String... var) {
//         Thread1 t1 = new Thread1();
//         t1.start();

//         Thread2 t2 = new Thread2();
//         t2.start();
//     }
// }
