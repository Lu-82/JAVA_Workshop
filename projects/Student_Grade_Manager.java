package projects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    private String name;
    private String rollNumber;
    private ArrayList<Double> grades;

    public Student(String name, String rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return "Roll: " + rollNumber + " | Name: " + name + " | Grades: " + grades + " | Average: "
                + String.format("%.2f", calculateAverage()) + " | Grade: " + getLetterGrade();
    }

    public void addGrade(double grade) {
        if (grade < 0 || grade > 100) {
            System.out.println("Invalid grade! Must be between 0 to 100");
            return;
        }
        grades.add(grade);
    }

    public double calculateAverage() {
        if (grades.isEmpty())
            return 0.0;

        double sum = 0;

        for (double grade : grades) {
            sum += grade;
        }

        return sum / grades.size();
    }

    public String getLetterGrade() {

        double avg = calculateAverage();
        if (avg >= 90)
            return "A";
        else if (avg >= 80)
            return "B";
        else if (avg >= 70)
            return "C";
        else if (avg >= 60)
            return "D";
        else
            return "F";
    }
}

class GradeManager {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudents(Student newStudent) {
        boolean isDuplicate = students.stream().anyMatch(s -> s.getRollNumber().equals(newStudent.getRollNumber()));

        if (isDuplicate) {
            System.out.println("Duplicate roll number! Student not added. ");
            return;
        }

        students.add(newStudent);
        System.out.println("Student added: " + newStudent.getName());
    }

    public Student findStudent(String rollNumber) throws StudentNotFoundException {
        for (Student s : students) {
            if (s.getRollNumber().equals(rollNumber)) {
                return s;
            }
        }

        throw new StudentNotFoundException("Student not found: " + rollNumber);
    }

    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students found. ");
            return;
        }

        for (Student s1 : students) {
            System.out.println(s1);
        }
    }

    public void printReport() {
        System.out.println("========= Class Report =========");
        for (Student s : students) {
            System.out.println("Roll: " + s.getRollNumber() +
                    " | Name: " + s.getName() +
                    " | Average: " + String.format("%.2f", s.calculateAverage()) +
                    " | Grade: " + s.getLetterGrade());
        }

        double classAverage = students.stream()
                .mapToDouble(s -> s.calculateAverage())
                .average()
                .orElse(0.0);

        System.out.println("============================");
        System.out.println("Class average: " + String.format("%.2f", classAverage));
    }

    Student findTopper() throws StudentNotFoundException {
        return students.stream()
                .max(Comparator.comparingDouble(s -> s.calculateAverage()))
                .orElseThrow(() -> new StudentNotFoundException("No students found!"));
    }
}

class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

public class Student_Grade_Manager {
    public static void main(String[] args) {
        GradeManager manager = new GradeManager();
        try (Scanner sc = new Scanner(System.in);) {
            

            while (true) {
                System.out.println("=============== Grade Manager============");
            System.out.println("1. Add student\n" +
                    "2. Add grade to student\n" +
                    "3. Display all students\n" +
                    "4. Print class report\n" +
                    "5. Find class topper\n" +
                    "6. Exit\n" +
                    "=============================");
            int choice;
            choice = sc.nextInt();
            sc.nextLine();
                switch (choice) {
                    case 1:
                        String name;
                        System.out.println("Enter Student Name: ");
                        name = sc.nextLine();
                        System.out.print("Enter roll number: ");
                        String roll = sc.nextLine();
                        manager.addStudents(new Student(name,roll));
                        break;

                    case 2:
                        
                        
                         System.out.print("Enter roll number: ");
                        String roll1 = sc.nextLine();
                        System.out.print("Enter grade: ");
                        double grade = sc.nextDouble();
                        sc.nextLine(); // clear buffer
                        try {
                            manager.findStudent(roll1).addGrade(grade);
                            System.out.println("Grade added!");
                        } catch (StudentNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 3:
                        manager.displayAll();
                        break;

                    case 4:
                        manager.printReport();
                        break;

                    case 5:
                        try {
                           Student topper = manager.findTopper();
                           System.out.println("Topper: "+topper.getName()+" with average: "+String.format("%.2f", topper.calculateAverage()));
                        } catch (StudentNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 6:
                        return;

                    default:
                        break;
                }
            }
        }

        // manager.addStudents(new Student("John Doe", "001"));
        // manager.addStudents(new Student("Jane Smith", "002"));
        // manager.addStudents(new Student("Michael Brown", "003"));

        // try {
        // manager.findStudent("001").addGrade(85);
        // manager.findStudent("001").addGrade(90);
        // manager.findStudent("002").addGrade(95);
        // manager.findStudent("002").addGrade(98);
        // manager.findStudent("003").addGrade(70);
        // manager.findStudent("003").addGrade(75);

        // manager.printReport();

        // Student topper = manager.findTopper();
        // System.out.println("\n🏆 Topper: " + topper.getName() +
        // " with average: " + String.format("%.2f", topper.calculateAverage()));

        // } catch (StudentNotFoundException e) {
        // System.out.println(e.getMessage());
        // }
    }
}
