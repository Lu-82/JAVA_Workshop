package Exercise;

class Teacher {
    String name;
    String subject;

    void teach() {
        System.out.println(name + " is teaching " + subject);
    }
}

class Student {
    String name;
    int rollNumber;

    void study(){
        System.out.println(name + " with roll number " + rollNumber + " is studying.");
    }
}

class Subject {
    String title;
    int code;

    void showDetails() {
        System.out.println("Subject: " + title + ", Code: " + code);
    }
}

public class Identify_class_obj {
    public static void main (String... var) {
        System.out.println("");
        
        Teacher t1 = new Teacher();
        t1.name = "Mr. williams";
        t1.subject = "DSA";
        t1.teach();

        Student s1 = new Student();
        s1.name = "Alice";
        s1.rollNumber = 23;
        s1.study(); 

        Subject sub1 = new Subject();
        sub1.title = "Data Structures and Algorithms";
        sub1.code = 101;
        sub1.showDetails(); 
    }
}
