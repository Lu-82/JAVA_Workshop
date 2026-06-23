package Collection.Set_;


import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*🎯 Task 2 — Remove duplicates from a list
Given this list: ["cat","dog","cat","bird","dog","fish"]
Remove all duplicates and print unique animals in insertion order
Then print them in alphabetical order
Check if "bird" is in the collection */


public class Hash_set {
    public static void main(String[] args) {
        List<String> animals = List.of("cat","dog","cat","bird","dog","fish");

        Set<String> unique = new LinkedHashSet<>(animals);
        System.out.println(unique);

        Set<String> sorted = new TreeSet<>(animals);
        System.out.println(sorted);

        System.out.println(sorted.contains("bird"));
    }
}
