import java.util.Scanner;
public class Q1b{
    Scanner sc=new Scanner(System.in);
    public class Account{
        void setSalary() {
        System.out.println("Enter number of salary accounts :\n");
        int accounts = sc.nextInt();
        double array[] = new double[accounts];
        double sum = 0;
        for (int i=0 ; i< accounts; i++){
            System.out.println("Enter your salary :\n");
            double salary = sc.nextDouble();
            array[i] = salary;
        } 
        for (int i=0 ; i< accounts; i++){
            sum += array[i];    
        }
        System.out.print("Total salary of all accounts is: \n"+ sum);
    }
}
    public static void main(String[] args){
        Q1b q1b = new Q1b();
        Account account = q1b.new Account();
        account.setSalary();
     

    }
}
