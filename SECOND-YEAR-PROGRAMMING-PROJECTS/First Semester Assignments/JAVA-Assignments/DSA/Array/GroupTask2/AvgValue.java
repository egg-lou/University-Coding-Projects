import java.util.Scanner;

public class AvgValue {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int capacity = sc.nextInt();

        int[] numArr = new int[capacity];

        for(int i = 0; i < capacity; i++){
            System.out.print("Enter element # " + (i+1) + ": ");
            numArr[i] = sc.nextInt();
        }

        double average = calcAverage(numArr);

        sc.close();

        System.out.println("Average of array: " + average);

    }

    public static double calcAverage(int[] array){
        if(array.length == 0){
            return 0;
        }

        int sum = 0;

        for(int num : array){
            sum += num;
        }

        return(double) sum/array.length;
    }
}
