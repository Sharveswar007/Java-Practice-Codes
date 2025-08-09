import java.util.Scanner;
public class Q1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your age:");
        int n = sc.nextInt();
        if (n>=18){
            System.out.println("Your are elegible to vote");
        }
        else{
            System.out.println("Your are not elegible to vote");
        }
        
        
    }
}