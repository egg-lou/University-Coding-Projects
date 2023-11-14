import java.util.Scanner;

public class ReverseArr {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        
        int[] arr = new int[size];

        for(int i = 0; i < size; i++){
            System.out.print("Element Number " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        
        revArr(arr);
        
        System.out.print("Reversed Array: ");
        printArr(arr);
        sc.close();
    }

    private static void revArr(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    private static void printArr(int[] arr){
        for(int value : arr){
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
