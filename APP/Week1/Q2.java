import java.util.Scanner;
public class Q2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your number:");
        int n = sc.nextInt();
        if (n%2==0){
            System.out.println("Your number is EVEN");
        }
        else{
            System.out.println("Your number is ODD");
        }
        
        
    }
}