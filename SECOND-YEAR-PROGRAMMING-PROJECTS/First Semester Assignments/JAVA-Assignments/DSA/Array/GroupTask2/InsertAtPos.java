import java.util.Scanner;

public class InsertAtPos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.print("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element Number " + (i + 1) + ": ");
            array[i] = sc.nextInt();
        }

        System.out.print("Original Array: ");
        displayArray(array);

        System.out.print("Enter the position to insert the element: ");
        int position = sc.nextInt() - 1;

        System.out.print("Enter the element to insert: ");
        int element = sc.nextInt();

        array = inElement(array, position, element);

        System.out.print("Array after insertion: ");
        displayArray(array);

        sc.close();
    }

    private static int[] inElement(int[] array, int position, int element) {
        int[] newArray = new int[array.length + 1];

        for (int i = 0; i < position; i++) {
            newArray[i] = array[i];
        }

        newArray[position] = element;

        for (int i = position + 1; i < newArray.length; i++) {
            newArray[i] = array[i - 1];
        }

        return newArray;
    }

    private static void displayArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
