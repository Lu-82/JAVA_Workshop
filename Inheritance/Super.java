package Inheritance;

class Super_class {
    int num = 20;
    public void display() {
        System.out.println("this is the display method of superclass");
    }
}
public class Super extends Super_class {
    int num = 20;
    public void display() {
        System.out.println("This is the display method of subclass");
    }

    public void my_method() {
        Super sub = new Super();
        sub.display();
        super.display();
        System.out.println("value of the variable named num in sub class:"+sub.num);
    }

    public static void main(String args[]) {
        Super obj = new Super();
        obj.my_method();
    }
}
