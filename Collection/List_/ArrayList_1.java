package Collection.List_;

/*🎯 Task 1 — Student roster
Write a program that:
Creates an ArrayList<String> called students
Adds 5 student names
Removes the student at index 2
Sorts the list alphabetically using Collections.sort()
Prints the sorted list and the index of a specific student using indexOf()*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayList_1 {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>(Arrays.asList("Raghu","Rahul","Ram","Rabi","Rina"));

        students.remove(2);

        Collections.sort(students);

        for(String name : students) {
            System.out.println(students.indexOf(name)+" Name: "+name);
        }

    }
    
}
