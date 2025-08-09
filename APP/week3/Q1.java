public class Q1 {
    public static void main(String[] args) {
        class employee{
            String name;
            int id;
            double salary;

        }
        employee emp1 = new employee();
        emp1.name = "John Doe";
        emp1.id = 12345;
        emp1.salary = 50000.0;
        employee emp2 = new employee();
        emp2.name = "Jane Smith";
        emp2.id = 67890;
        emp2.salary = 60000.0;
        System.out.println("Employee 1: " + emp1.name + ", ID: " + emp1.id + ", Salary: " + emp1.salary);
        System.out.println("Employee 2: " + emp2.name + ", ID: " + emp2.id + ", Salary: " + emp2.salary);
    }
}