import java.util.Scanner;
public class foot10{
public static void main(String[] arrg){
double height,inches,foots;
Scanner input= new Scanner(System.in);
height=input.nextDouble();
inches=height/2.54;
foots=inches/12;
System.out.println("Your Height in cm is "+height+" while in feet is "+inches+" and inches is " +foots);
}
}