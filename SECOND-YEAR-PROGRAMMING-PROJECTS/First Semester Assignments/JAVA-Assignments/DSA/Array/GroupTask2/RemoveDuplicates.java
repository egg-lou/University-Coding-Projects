/**
 * The RemoveDuplicates class takes an array of integers as input, removes any duplicate elements, and
 * returns the updated array.
 */
import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int arrayLength = sc.nextInt();

        int[] numbers = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            System.out.printf("Element %d: ", i + 1);
            numbers[i] = sc.nextInt();
        }

        arrayLength = RemoveDuplicate(numbers);

        numbers = Arrays.copyOf(numbers, arrayLength);

        System.out.println("Updated Array: " + Arrays.toString(numbers));
    }


    static int RemoveDuplicate(int[] numbers) {
        int index = 0;
        
        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 1; i++)
            if (numbers[i] != numbers[i + 1])
                numbers[index++] = numbers[i];

        numbers[index++] = numbers[numbers.length - 1];

        return index;
    }
}
