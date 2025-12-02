package Inheritance;

class parents{
    parents(){
        System.out.println("hey dear");
    }
}
public class Constructor extends parents {
    Constructor (){
        super();
        System.out.println("Child cosntrucor");
    }
    public static void main(String... var){
        Constructor co = new Constructor();
    }
}
