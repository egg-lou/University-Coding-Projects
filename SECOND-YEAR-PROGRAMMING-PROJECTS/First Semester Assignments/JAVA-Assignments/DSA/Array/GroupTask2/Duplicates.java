public class Duplicates {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 2, 7, 8, 5, 9};

        System.out.println("Number of duplicates per number in the array: ");
        countDuplicates(array);
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
