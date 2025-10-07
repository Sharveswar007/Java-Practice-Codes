// LAB PROBLEM 4: Abstract Employee and Payable Interface
abstract class Employee {
    protected String name;
    protected double salary;
    
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    
    public abstract double calculateBonus();
}

interface Payable {
    void generatePaySlip();
}

class Manager extends Employee implements Payable {
    private String department;
    
    public Manager(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }
    
    @Override
    public double calculateBonus() {
        return salary * 0.20; // 20% bonus for managers
    }
    
    @Override
    public void generatePaySlip() {
        double bonus = calculateBonus();
        double totalSalary = salary + bonus;
        
        System.out.println("\n💼 PAY SLIP");
        System.out.println("   ================================");
        System.out.println("   Employee: " + name);
        System.out.println("   Department: " + department);
        System.out.println("   Base Salary: $" + salary);
        System.out.println("   Bonus (20%): $" + bonus);
        System.out.println("   --------------------------------");
        System.out.println("   Total Salary: $" + totalSalary);
        System.out.println("   ================================");
    }
}

public class EmployeeTest {
    public static void main(String[] args) {
        System.out.println("=== Lab Problem 4: Employee and Payable Interface ===");
        
        Manager manager = new Manager("John Smith", 5000.0, "IT");
        manager.generatePaySlip();
    }
}