/**
 * The FindIndex class allows the user to input an element and finds its index in the given array.
 */
import java.util.*;

public class FindIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] numArr = {3, 18, 7, 20};

        System.out.print("Enter the element to find: ");
        int targetElement = sc.nextInt();

        int index = findIndex(numArr, targetElement);

        if(index == -1){
            System.out.println("Element not found");
        }
        else {
            System.out.println("Element found at index: " + index);
        }
    }

    public static int findIndex(int[] array, int target){
        for(int i = 0; i < array.length; i++){
            if(array[i] == target){
                return i;
            }
        }
        return -1;
    }
}
