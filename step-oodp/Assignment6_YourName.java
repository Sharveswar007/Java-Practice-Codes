
import java.util.*;

class Employee {
    private String empId;
    private String empName;
    private String department;
    private String designation;
    private double baseSalary;
    private String joinDate;
    private boolean[] attendanceRecord; // 30 days
    private String type; // Full-time, Part-time, Contract

    private static int totalEmployees = 0;
    private static String companyName = "Default Company";
    private static double totalSalaryExpense = 0.0;
    private static int workingDaysPerMonth = 30;

    public Employee(String empId, String empName, String department, String designation, double baseSalary, String joinDate, String type) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.designation = designation;
        this.baseSalary = baseSalary;
        this.joinDate = joinDate;
        this.type = type;
        this.attendanceRecord = new boolean[workingDaysPerMonth];
        totalEmployees++;
    }

    public void markAttendance(int day, boolean present) {
        if (day < 1 || day > workingDaysPerMonth) {
            System.out.println("Invalid day for attendance.");
            return;
        }
        attendanceRecord[day - 1] = present;
    }

    public double calculateSalary() {
        int presentDays = 0;
        for (boolean present : attendanceRecord) if (present) presentDays++;
        double salary = 0.0;
        switch (type) {
            case "Full-time":
                salary = baseSalary;
                break;
            case "Part-time":
                salary = baseSalary * (presentDays / (double) workingDaysPerMonth);
                break;
            case "Contract":
                salary = baseSalary * (presentDays / (double) workingDaysPerMonth) * 0.9;
                break;
        }
        totalSalaryExpense += salary;
        return salary;
    }

    public double calculateBonus() {
        int presentDays = 0;
        for (boolean present : attendanceRecord) if (present) presentDays++;
        if (presentDays >= 28) return 0.1 * baseSalary;
        else if (presentDays >= 25) return 0.05 * baseSalary;
        else return 0.0;
    }

    public void generatePaySlip() {
        double salary = calculateSalary();
        double bonus = calculateBonus();
        System.out.println("\n--- Pay Slip for " + empName + " ---");
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Salary (after attendance): " + salary);
        System.out.println("Bonus: " + bonus);
        System.out.println("Total: " + (salary + bonus));
    }

    public void requestLeave() {
        System.out.println(empName + " requested leave.");
    }

    public String getDepartment() { return department; }
    public String getType() { return type; }
    public String getEmpName() { return empName; }
    public static int getTotalEmployees() { return totalEmployees; }
    public static double getTotalSalaryExpense() { return totalSalaryExpense; }
    public static void setCompanyName(String name) { companyName = name; }
    public static String getCompanyName() { return companyName; }
}

class Department {
    private String deptId;
    private String deptName;
    private Employee manager;
    private Employee[] employees;
    private double budget;
    private int empCount;

    public Department(String deptId, String deptName, Employee manager, double budget) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.manager = manager;
        this.budget = budget;
        this.employees = new Employee[10];
        this.empCount = 0;
    }
    public void addEmployee(Employee emp) {
        employees[empCount++] = emp;
    }
    public double getDepartmentExpense() {
        double total = 0.0;
        for (int i = 0; i < empCount; i++) {
            total += employees[i].calculateSalary();
        }
        return total;
    }
}

public class Assignment6_YourName {
    public static void main(String[] args) {
        Employee.setCompanyName("Tech Solutions");
        // Create employees
        Employee e1 = new Employee("E001", "Alice", "IT", "Developer", 3000, "2024-01-01", "Full-time");
        Employee e2 = new Employee("E002", "Bob", "IT", "Tester", 2000, "2024-01-01", "Part-time");
        Employee e3 = new Employee("E003", "Charlie", "HR", "Recruiter", 2500, "2024-01-01", "Contract");
        // Mark attendance
        for (int i = 1; i <= 30; i++) {
            e1.markAttendance(i, true);
            e2.markAttendance(i, i % 2 == 0);
            e3.markAttendance(i, i <= 25);
        }
        // Generate pay slips
        e1.generatePaySlip();
        e2.generatePaySlip();
        e3.generatePaySlip();
        // Department
        Department itDept = new Department("D001", "IT", e1, 10000);
        itDept.addEmployee(e1);
        itDept.addEmployee(e2);
        System.out.println("\nIT Department Expense: " + itDept.getDepartmentExpense());
        // Static reporting
        System.out.println("Total Employees: " + Employee.getTotalEmployees());
        System.out.println("Total Salary Expense: " + Employee.getTotalSalaryExpense());
        System.out.println("Company Name: " + Employee.getCompanyName());
    }
}
