/**
 * The Average class calculates the average value of an array of integers entered by the user.
 */
import java.util.*;

public class Average{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("CALCULATING THE AVERAGE VALUE OF AN ARRAY\n");

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.print("\nArray: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        double average = (double) sum / size;

        System.out.println("\nAverage: " + average);

        scanner.close();
    }
}