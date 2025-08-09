import java.util.Scanner;

public class Q3b {
    public class Employee {
        void findHighestSalary() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number of employees:");
            int employees = sc.nextInt();
            double[] array = new double[employees];

            for (int i = 0; i < employees; i++) {
                System.out.println("Enter salary:");
                array[i] = sc.nextDouble();
            }

            double highest = array[0];
            for (int i = 1; i < employees; i++) {
                if (array[i] > highest) {
                    highest = array[i];
                }
            }

            System.out.printf("Highest employee salary is: %.2f\n", highest);
        }
    }

    public static void main(String[] args) {
        Q3b q3b = new Q3b();
        Employee emp = q3b.new Employee();
        emp.findHighestSalary();
    }
}
