class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee[id=" + id + ", name=" + name + ", salary=$" + salary + "]";
    }
}

public class Topic1_EmployeeDemo {
    public static void main(String[] args) {
        System.out.println("=== TOPIC 1: toString() and getClass() ===\n");
        
        Employee e1 = new Employee(101, "John Smith", 75000);
        Employee e2 = new Employee(102, "Sarah Johnson", 82000);
        Employee e3 = new Employee(103, "Mike Davis", 68000);
        
        System.out.println("Employee Details:");
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
        
        System.out.println("\nClass Information:");
        System.out.println("e1 Class Name: " + e1.getClass().getName());
        System.out.println("e2 Class Name: " + e2.getClass().getName());
        System.out.println("e3 Simple Name: " + e3.getClass().getSimpleName());
    }
}
