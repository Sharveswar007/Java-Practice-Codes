import java.util.Scanner;
public class Q2b{
    Scanner sc=new Scanner(System.in);
    public class Order{
        void Setorders() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of orders :\n");
        int orders = sc.nextInt();
        double array[] = new double[orders];
        for (int i=0 ; i< orders; i++){
            System.out.println("Enter your price :\n");
            double price = sc.nextDouble();
            array[i] = price;
        }
        double sum = 0;
        for (int i=0 ; i< orders; i++){
            sum += array[i];    
        }
        System.out.print("Total price of all orders is:\n"+ sum);
    }
}
    public static void main(String[] args){
        Q2b q2b = new Q2b();
        Order order = q2b.new Order();
        order.Setorders();

    }
}