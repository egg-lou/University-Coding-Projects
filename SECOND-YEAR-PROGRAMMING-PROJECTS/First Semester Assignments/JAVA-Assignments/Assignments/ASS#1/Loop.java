import java.util.*;

public class Loop{
    public static void main(String[] args){
         int rows;

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome! This program will print a right triangle using asterisks (*), depending on the number of rows entered.");

        System.out.print("Enter the number of rows: ");
        rows = sc.nextInt();

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        sc.close();
    }   
}