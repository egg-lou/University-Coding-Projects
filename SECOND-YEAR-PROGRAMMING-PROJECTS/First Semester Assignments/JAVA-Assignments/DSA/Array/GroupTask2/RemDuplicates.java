public class RemDuplicates {
    public static void main(String[] args) {
        int[] array = {20,20,30,40,50,50,50};

        System.out.println("Array without duplicates: ");
        int[] resultArray = removeDuplicates(array);

        for (int i = 0; i < resultArray.length; i++) {
            System.out.print(resultArray[i]);
            if (i < resultArray.length - 1) {
                System.out.print(" ");
            }
        }
    }

    static int[] removeDuplicates(int[] array) {
        int uniqueCount = 0;

        for (int i = 0; i < array.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                uniqueCount++;
            }
        }

        int[] resultArray = new int[uniqueCount];
        int currentIndex = 0;

        for (int i = 0; i < array.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                resultArray[currentIndex++] = array[i];
            }
        }

        int[] resizedArray = new int[currentIndex];
        System.arraycopy(resultArray, 0, resizedArray, 0, currentIndex);

        return resizedArray;
    }
}
