class Employee {
    String name;
    int id;
    double salary;
    
    Employee() {
        this("Unknown", 0);
    }
    
    Employee(String name, int id) {
        this(name, id, 0.0);
    }
    
    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
}

public class Q4 {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = new Employee("John", 101);
        Employee e3 = new Employee("Jane", 102, 50000);
        
        System.out.println(e1.name + " " + e1.id + " " + e1.salary);
        System.out.println(e2.name + " " + e2.id + " " + e2.salary);
        System.out.println(e3.name + " " + e3.id + " " + e3.salary);
    }
}
