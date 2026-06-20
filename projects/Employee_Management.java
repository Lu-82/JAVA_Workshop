package projects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
// import java.util.stream.Collector;
import java.util.stream.Collectors;

abstract class Employee {
    private String name;
    private String id;
    private String department;

    public Employee(String id, String name, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    abstract double calculateSalary();

    abstract String getType();

    @Override
    public String toString() {
        return id + " | " + name + " | " + department + " | " + getType() + " | Rs."
                + String.format("%.2f", calculateSalary());
    }
}

class EmployeeManager {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee e) {
        boolean isDuplicate = employees.stream()
                .anyMatch(emp -> emp.getId().equals(e.getId()));

        if (isDuplicate) {
            System.out.println("Employee ID already exists: " + e.getId());
            return;
        }

        employees.add(e);
        System.out.println("Added: " + e.getName());
    }

    public Employee findById(String id) throws EmployeeNotFoundException {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found: " + id));
    }

    public void displayAll() {
        boolean isEmpty = employees.isEmpty();

        if (isEmpty) {
            System.out.println("No employees found. ");
            return;
        }

        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    public Map<String, List<Employee>> groupByDepartment() {
        return employees.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment()));
    }

    public void displayByDepartment() {
        Map<String, List<Employee>> grouped = groupByDepartment();
        grouped.forEach((detp, emps) -> {
            System.out.println("\n[" + detp + "]");
            emps.forEach(e -> System.out.println(" " + e));
        });
    }

    public Employee findHighestEarner() throws EmployeeNotFoundException {
        return employees.stream()
                .max(Comparator.comparingDouble(e -> e.calculateSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException("No employees found!"));
    }

    public void printSalaryReport() {
        System.out.println("=============Salary Report==============");

        Map<String, List<Employee>> grouped = groupByDepartment();
        grouped.forEach((dept, emps) -> {
            System.out.println("\n[" + dept + "]");
            emps.forEach(e -> System.out.println(
                    " " + e.getName() + " | " + e.getType() + " | Rs." + String.format("%.2f", e.calculateSalary())));
        });

        double totalPayroll = employees.stream()
                .mapToDouble(e -> e.calculateSalary())
                .sum();

        System.out.println("\n-----------------------------------");
        System.out.println("Total payroll: Rs." + String.format("%.2f", totalPayroll));
        System.out.println("=============================");

    }
}

class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    FullTimeEmployee(String id, String name, String department, double monthlySalary) {
        super(id, name, department);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }

    @Override
    public String getType() {
        return "Full-Time";
    }
}

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String id, String name, String department, double hourlyRate, int hoursWorked) {
        super(id, name, department);

        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String getType() {
        return "Part-Time";
    }
}

public class Employee_Management {
    public static void main(String... var) {

        String name;
        String id;
        String department;
        double monthlySalary;
        double hourlyRate;
        int hoursWorked;

        EmployeeManager manager = new EmployeeManager();
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("====== Employee Management ======\n" + //
                        "1. Add employee\n" + //
                        "2. View all employees\n" + //
                        "3. View by department\n" + //
                        "4. Find highest earner\n" + //
                        "5. Print salary report\n" + //
                        "6. Exit\n" + //
                        "=================================");

                System.out.print("Enter option: ");
                int option = sc.nextInt();
                sc.nextLine();
                switch (option) {
                    case 1:
                        System.out.println("a. FullTime: ");
                        System.out.println("b. PartTime: ");
                        System.out.print("Choose option: ");
                        char op = sc.next().charAt(0);
                        sc.nextLine();
                        switch (op) {
                            case 'a':
                                System.out.print("Enter name: ");
                                name = sc.nextLine();
                                System.out.print("Enter id: ");
                                id = sc.nextLine();
                                System.out.print("Enter department: ");
                                department = sc.nextLine();
                                System.out.print("Enter monthly salary: ");
                                monthlySalary = sc.nextDouble();
                                sc.nextLine();
                                manager.addEmployee(new FullTimeEmployee(id, name, department, monthlySalary));
                                break;
                            case 'b':
                                System.out.print("Enter name: ");
                                name = sc.nextLine();
                                System.out.print("Enter id: ");
                                id = sc.nextLine();
                                System.out.print("Enter department: ");
                                department = sc.nextLine();
                                System.out.print("Enter hourlyRate: ");
                                hourlyRate = sc.nextDouble();
                                sc.nextLine();
                                System.out.print("Enter hoursWorked: ");
                                hoursWorked = sc.nextInt();
                                sc.nextLine();
                                manager.addEmployee(
                                        new PartTimeEmployee(id, name, department, hourlyRate, hoursWorked));
                                break;
                            default:
                                System.out.println("Enter valid option!");
                        }
                        break;
                    case 2:
                        manager.displayAll();
                        break;
                    case 3:
                        manager.displayByDepartment();
                        break;
                    case 4:
                        try {
                            Employee topper = manager.findHighestEarner();
                            System.out.println("\n Highest Earner: " + topper.getName()
                                    + " (" + topper.getType() + ")"
                                    + " — Rs." + String.format("%.2f", topper.calculateSalary()));
                        } catch (EmployeeNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        manager.printSalaryReport();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Please enter valid option!");
                        break;
                }
            }
        }
    }
}
