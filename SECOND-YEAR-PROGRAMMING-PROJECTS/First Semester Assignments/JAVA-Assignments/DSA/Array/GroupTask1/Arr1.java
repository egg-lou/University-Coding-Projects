package GroupTask1;
import java.util.*;

public class Arr1 {

    public static final int ADD_TASK = 1;
    public static final int REMOVE_TASK = 2;
    public static final int UPDATE_TASK = 3;
    public static final int SEARCH_TASK = 4;
    public static final int DISPLAY_TASKS = 5;
    public static final int EXIT = 6;

    public static void main(String[] args) {
        int capacity = 10;
        String[] arr = new String[capacity];

        Scanner sc = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = getValidChoice(sc);

            switch (choice) {
                case ADD_TASK:
                    addElement(arr, capacity, sc);
                    break;
                case REMOVE_TASK:
                    removeElement(arr, sc);
                    break;
                case UPDATE_TASK:
                    updateElement(arr, sc);
                    break;
                case SEARCH_TASK:
                    searchElement(arr, sc);
                    break;
                case DISPLAY_TASKS:
                    displayArray(arr);
                    break;
                case EXIT:
                    System.out.println("Exiting the program...");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    public static int getValidChoice(Scanner sc) {
        int choice;
        do {
            System.out.print("\nEnter your choice: ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
            choice = sc.nextInt();
        } while (choice < 1 || choice > 6);

        return choice;
    }

    public static void displayArray(String[] arr) {
        int taskCount = countTasks(arr);
        System.out.println("\nTasks: (" + taskCount + " / " + arr.length + ")");
        boolean hasTasks = false;

        for (String task : arr) {
            if (task != null) {
                hasTasks = true;
                System.out.println("- " + task);
            }
        }

        if (!hasTasks) {
            System.out.println("No tasks available");
        }
    }

    public static void displayMenu() {
        System.out.println("\n\nMenu: Tasks");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. Update Task");
        System.out.println("4. Search Task");
        System.out.println("5. Display Tasks");
        System.out.println("6. Exit");
    }

    public static void addElement(String[] arr, int capacity, Scanner sc) {
        System.out.print("Enter the position in the array where you want to add: ");
        int positionToAdd = sc.nextInt() - 1;

        sc.nextLine();

        boolean isValidPosition = positionToAdd >= 0 && positionToAdd < capacity;

        if (isValidPosition){
            if(arr[positionToAdd] == null){
                System.out.print("Task to add: ");
                String taskToAdd = sc.nextLine();
                arr[positionToAdd] = taskToAdd;
                System.out.println("Task added successfully");
            } else {
                System.err.println("Task already exists at this position");
            }
        } else {
            System.err.println("Out of range");
        }
    }

    public static void removeElement(String[] arr, Scanner sc) {
        System.out.print("Enter the position in the array where you want to remove: ");
        int positionToRemove = sc.nextInt() - 1;

        boolean isValidPosition = positionToRemove >= 0 && positionToRemove < arr.length;

        if (isValidPosition) {
            if (arr[positionToRemove] != null) {
                arr[positionToRemove] = null;
                System.out.println("Task removed successfully");
            } else {
                System.err.println("Does not have task at this position");
            }
        } else {
            System.err.println("Out of range");
        }
    }

    public static void updateElement(String[] arr, Scanner sc) {
        System.out.print("Enter the position in the array where you want to update: ");
        int positionToUpdate = sc.nextInt() - 1;

        sc.nextLine();
        boolean isValidPosition = positionToUpdate >= 0 && positionToUpdate < arr.length;

        if (isValidPosition) {
            if (arr[positionToUpdate] != null) {
                System.out.print("Update Task: ");
                String taskToUpdate = sc.nextLine();
                arr[positionToUpdate] = taskToUpdate;
                System.out.println("Task updated successfully");
            } else {
                System.err.println("Does not have task at this position");
            }
        } else {
            System.err.println("Out of range");
        }
    }

    public static void searchElement(String[] arr, Scanner sc) {
        System.out.print("Enter the position you want to search: ");
        int positionToSearch = sc.nextInt() - 1;

        boolean isValidPosition = positionToSearch >= 0 && positionToSearch < arr.length;

        if (isValidPosition) {
            if (arr[positionToSearch] != null) {
                System.out.println("Task in position " + (positionToSearch + 1) + " is " + arr[positionToSearch]);
            } else {
                System.err.println("Does not have task at this position");
            }
        } else {
            System.err.println("Out of range");
        }
    }

    public static int countTasks(String[] arr){
        int count = 0;
        for(String task : arr){
            if(task != null){
                count++;
            }
        }
        return count;
    }
}