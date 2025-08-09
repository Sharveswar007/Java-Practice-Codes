import java.util.Scanner;
public class Q5{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n = 2;
        System.out.println("before post increnment");
        System.out.println(n);
        System.out.println("after post increnment");
        System.out.println(n++);
        System.out.println("before pre increnment");
        System.out.println(n);
        System.out.println("after pre increnment");
        System.out.println(++n);
    }
}