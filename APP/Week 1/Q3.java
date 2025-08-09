import java.util.Scanner;
public class Q3{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your number:");
        int n = sc.nextInt();
        if (n%3==0){
            System.out.println("divisible");
        }
        else{
            System.out.println("not divisible");
        }
        
        
    }
}