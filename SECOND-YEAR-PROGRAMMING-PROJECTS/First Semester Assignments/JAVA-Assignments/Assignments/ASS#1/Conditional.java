import java.util.*;

public class Conditional {
    public static void main(String[] args){
        double grade;

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to our Grade Evaluation Checker! The program will check if the grade is passed or failed");

        System.out.print("Enter Grade: ");
        grade = sc.nextDouble();

        if (grade <= 74) {
            System.out.println("FAILED");
        } else {
            System.out.println("PASSED");
        }
        sc.close();
    }
}