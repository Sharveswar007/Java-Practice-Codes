import java.util.Scanner;
public class Q3a{
public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number Employee :\n");
        int Employee = sc.nextInt();
        double array[] = new double[Employee];
        for (int i=0 ; i< Employee; i++){
            System.out.println("Enter your salary :\n");
            double salary = sc.nextDouble();
            array[i] = salary;
        }
        double highest = 0;
        for (int i=0 ; i< Employee; i++){
            if (highest < array[i]) {
                highest = array[i];
            }
        }
        System.out.print("highest Employee with salary is: \n"+ highest);

    }
}