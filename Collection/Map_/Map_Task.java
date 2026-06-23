package Collection.Map_;

import java.util.HashMap;

import java.util.Scanner;
import java.util.TreeMap;

/*🎯 Task 3 — Phone directory
Build a simple phone book using HashMap<String, String>:
Add at least 4 contacts (name → number)
Look up a contact by name and print their number
Update an existing contact's number
Print all contacts in alphabetical order by name (hint: use TreeMap or sort the keys) */

public class Map_Task {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            HashMap<String,String> book = new HashMap<>();
            book.put("Raghu", "8764532435");
            book.put("Rahul","9845623746");
            book.put("Rina", "9736452736");
            book.put("Rani", "9087364523");

            System.out.print("Enter name: ");
            String name = sc.nextLine();
            if(book.containsKey(name))
                System.out.println(book.get(name));
            else
                System.out.println("user not found");

            book.put("Raghu","9873465123");

            new TreeMap<>(book).forEach((k,v) -> System.out.println(k+": "+v));
        }
    }
}
