import java.util.Scanner;
public class Q4{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your string:");
        String n = sc.nextLine();
        String new1[]=n.split(" ");
        for (int i=0;i<new1.length;i++){
            System.out.println(new1[i]);
        }
        
        
        
    }
}