/**
 * The FindDuplicates class allows the user to input an array of integers and then counts the number of
 * duplicates for each number in the array.
 */
import java.util.*;

public class FindDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int arrayLength = sc.nextInt();

        int[] numbers = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            System.out.printf("Element %d: ", i + 1);
            numbers[i] = sc.nextInt();
        }

        System.out.println("Number of duplicates per number in the array: ");
        countDuplicates(numbers);
    }

    static void countDuplicates(int[] array) {
        int max = findMax(array);
        int[] countArray = new int[max + 1];

        for (int value : array) {
            countArray[value]++;
        }

        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] > 1) {
                System.out.println("Number: " + i + ", Count: " + countArray[i]);
            }
        }
    }

    static int findMax(int[] array) {
        int max = array[0];
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
