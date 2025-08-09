import java.util.Scanner;
public class Q1a{
public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of salary accounts :\n");
        int accounts = sc.nextInt();
        double array[] = new double[accounts];
        for (int i=0 ; i< accounts; i++){
            System.out.println("Enter your salary :\n");
            double salary = sc.nextDouble();
            array[i] = salary;
        }
        double sum = 0;
        for (int i=0 ; i< accounts; i++){
            sum += array[i];    
        }
        System.out.print("Total salary of all accounts is: \n"+ sum);

    }
}