// Problem 2: Employee Authentication System - equals(), ==, hashCode()
import java.util.HashSet;
import java.util.Objects;

class Employee {
    private String empCode;
    private String name;
    
    public Employee(String empCode, String name) {
        this.empCode = empCode;
        this.name = name;
    }
    
    // Override equals() - same empCode means same employee
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return empCode.equals(employee.empCode);
    }
    
    // Override hashCode() based on empCode
    @Override
    public int hashCode() {
        return Objects.hash(empCode);
    }
    
    // Override toString() showing both fields
    @Override
    public String toString() {
        return "Employee{empCode='" + empCode + "', name='" + name + "'}";
    }
}

public class EmployeeAuth {
    public static void main(String[] args) {
        System.out.println("=== Employee Authentication System - equals() & hashCode() ===\n");
        
        // Create Employee objects
        Employee e1 = new Employee("BL001", "Ritika");
        Employee e2 = new Employee("BL001", "Ritika S.");
        Employee e3 = new Employee("BL002", "Amit");
        
        // Display employees
        System.out.println("e1: " + e1);
        System.out.println("e2: " + e2);
        System.out.println("e3: " + e3);
        
        // Compare using == (reference comparison)
        System.out.println("\n--- Reference Comparison (==) ---");
        System.out.println("e1 == e2: " + (e1 == e2)); // false (different objects)
        
        // Compare using equals() (content comparison)
        System.out.println("\n--- Content Comparison (equals()) ---");
        System.out.println("e1.equals(e2): " + e1.equals(e2)); // true (same empCode)
        System.out.println("e1.equals(e3): " + e1.equals(e3)); // false (different empCode)
        
        // Test hashCode()
        System.out.println("\n--- Hash Codes ---");
        System.out.println("e1.hashCode(): " + e1.hashCode());
        System.out.println("e2.hashCode(): " + e2.hashCode()); // same as e1
        System.out.println("e3.hashCode(): " + e3.hashCode()); // different
        
        // Test using HashSet
        System.out.println("\n--- HashSet Test ---");
        HashSet<Employee> employees = new HashSet<>();
        employees.add(e1);
        employees.add(e2); // Won't be added (same empCode as e1)
        employees.add(e3);
        
        System.out.println("HashSet size: " + employees.size()); // 2 (e1 and e3 only)
        System.out.println("HashSet contains e1: " + employees.contains(e1));
        System.out.println("HashSet contains e2: " + employees.contains(e2)); // true (equals e1)
    }
}