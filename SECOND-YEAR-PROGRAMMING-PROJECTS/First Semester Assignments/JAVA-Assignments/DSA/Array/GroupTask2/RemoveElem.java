import java.util.Scanner;

public class RemoveElem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1,2,3,4,5};


        System.out.print("Original Array: ");
        displayArray(arr);

        System.out.print("Enter the element to remove: ");
        int elementToRemove = sc.nextInt();

        arr = remElement(arr, elementToRemove);

        displayArray(arr);

        sc.close();
    }

    public static int[] remElement(int[] array, int element){
        
        boolean elementFound = false;
        int index = -1;
        for(int i = 0; i < array.length; i++){
            if(array[i] == element){
                elementFound = true;
                index = i;
                break;
            }
        }

        if(elementFound) {
            int [] newArray = new int[array.length - 1];
            for(int i = 0, j = 0; i < array.length; i++){
                if(i != index){
                    newArray[j++] = array[i];
                }
            }
            System.out.println("Element " + element + " removed successfully");
            System.err.print("New Array: ");
            return newArray;
        } else {
            System.out.println("Element " +element+ " not found");
            System.out.print("Array remains unchanged: ");
            return array;
        }
    }

    private static void displayArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
