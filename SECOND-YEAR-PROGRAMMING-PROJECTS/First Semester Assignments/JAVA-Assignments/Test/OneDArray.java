public class OneDArray {
    public static void main(String[] args) {
        int[] arr = new int[5]; //Initialize an array of size 5

        arr[0] = 10; //Insert 10 at index 0
        arr[1] = 20; //Insert 20 at index 1

        traverse(arr); //Traverse the array

        insertAtBeginning(arr, 30); //Insert 30 at the beginning
        System.out.println("\nArray after inserting 30 at the beginning: ");
        traverse(arr); //Traverse the array

        insertAtEnd(arr, 40); //Insert 40 at the end
        System.out.println("\nArray after inserting 40 at the end: ");
        traverse(arr); //Traverse the array

        insertAtPosition(arr, 50, 3); //Insert 50 at position 3
        System.out.println("\nArray after inserting 50 at position 3: ");
        traverse(arr); //Traverse the array

        deleteAtBeginning(arr); //Delete at beginning
        System.out.println("\nArray after deleting at beginning: ");
        traverse(arr); //Traverse the array

        deleteAtEnd(arr); //Delete at end
        System.out.println("\nArray after deleting at end: ");
        traverse(arr); //Traverse the array

        deleteAtPosition(arr, 3); //Delete at position 3
        System.out.println("\nArray after deleting at position 3: ");
        traverse(arr); //Traverse the array

    }

    public static void traverse(int[] arr) { //Traverse the array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " "); //Print the array element
        }
    }

    public static void insertAtBeginning(int[] arr, int data) { //Insert at beginning
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1]; //Shift the elements to right
        }
        arr[0] = data; //Insert data at first position
    }

    public static void insertAtEnd(int[] arr, int data) { //Insert at end
        arr[arr.length - 1] = data; //Insert data at last position
    }

    public static void insertAtPosition(int[] arr, int data, int position) { //Insert at position
        for (int i = arr.length - 1; i > position - 1; i--) {
            arr[i] = arr[i - 1]; //Shift the elements to right
        }
        arr[position - 1] = data; //Insert data at given position
    }

    public static void deleteAtBeginning(int[] arr) { //Delete at beginning
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1]; //Shift the elements to left
        }
        arr[arr.length - 1] = 0; //Set last element to 0
    }

    public static void deleteAtEnd(int[] arr) { //Delete at end
        arr[arr.length - 1] = 0; //Set last element to 0
    }

    public static void deleteAtPosition(int[] arr, int position) { //Delete at position
        for (int i = position - 1; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1]; //Shift the elements to left
        }
        arr[arr.length - 1] = 0; //Set last element to 0
    }

    public static void search(int[] arr, int data) { //Search an element
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == data) { //If element is found
                System.out.println("Element is found at index: " + i);
                return;
            }
        }
        System.out.println("Element is not found");
    }
}