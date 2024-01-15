import java.util.*;

public class InputOutput {
    public static void main(String[] args) {
    double num1, num2, sum;

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to our Sum Calculator! This program will calculate the sum of the two numbers and display the result.");

        System.out.print("Enter first number: ");
        num1 = sc.nextDouble();

        System.out.print("Enter second number: ");

        num2 = sc.nextDouble();

        sum = num1 + num2;

        System.out.println("The sum is: " + sum);

        sc.close();
    }
}