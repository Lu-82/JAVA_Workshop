package projects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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
        EmployeeManager manager = new EmployeeManager();

        manager.addEmployee(new FullTimeEmployee("E001", "John Doe", "Engineering", 95000));
        manager.addEmployee(new PartTimeEmployee("E002", "Sara Khan", "Engineering", 300, 80));
        manager.addEmployee(new FullTimeEmployee("E003", "Ravi Sharma", "Marketing", 72000));
        manager.addEmployee(new PartTimeEmployee("E004", "Priya Patel", "Marketing", 250, 60));
        manager.addEmployee(new FullTimeEmployee("E001", "Duplicate", "HR", 50000));

        manager.printSalaryReport();

        try {
            Employee topper = manager.findHighestEarner();
            System.out.println("\n Highest Earner: " + topper.getName()
                    + " (" + topper.getType() + ")"
                    + " — Rs." + String.format("%.2f", topper.calculateSalary()));
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
