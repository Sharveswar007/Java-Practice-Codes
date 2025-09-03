public class Q3 {
    static class Employee {
        double salary;
        double bonus, overtime;
        public void calculateSalary(){
            System.out.println("Calculating salary for employee.");

        }
    }
    static class Manager extends Employee {
        @Override
        public void calculateSalary(){
            System.out.println("Calculating salary for manager with bonus.");
            this.salary += bonus;
        }
    }
    static class Developer extends Employee{
        @Override
        public void calculateSalary(){
            System.out.println("Calculating salary for developer with overtime pay.");
            this.salary += overtime;
        }
    }
    public static void main(String[] args){
        Manager m1 = new Manager();
        Developer d1 = new Developer();

        m1.calculateSalary();
        d1.calculateSalary();
    }
}
