import java.util.List;
import java.util.ArrayList;

public class Test2 {

    public static void main(String[] args) {
        System.out.println("Testing Euclidean GCD Function: \n");

        long[][] testCases = {
            {48, 18, 6},
            {60, 45, 15},
            {608, 133, 19},
            {9, 6, 3},
            {17, 8, 1},
            {14, 12, 2},
            {10, 5, 5},
            {120, 24, 24},
            {60, 45, 15},
            {17, 23, 1}
        };

        int passedCount = 0;
        int failedCount = 0;

        for (int i = 0; i < testCases.length; i++) {
            long[] testCase = testCases[i];
            long input1 = testCase[0];
            long input2 = testCase[1];
            long expected = testCase[2];

            List<Long> gcdValues = new ArrayList<>();
            long actual = Main2.euclideanGCD(input1, input2, gcdValues);

            if(actual == expected){
                passedCount++;
            }else{
                failedCount++;
            }

            printTestResult("Test #" + (i + 1), actual, expected, gcdValues);
        }
    
        System.out.println();
        System.out.println("Tests Passed: " + passedCount);
        System.out.println("Tests Failed: " + failedCount);

    }

    public static void printTestResult(String testName, long actual, long expected, List<Long> gcdValues) {
        String result;
        String colorCode;

        if (actual == expected) {
            result = "Passed";
            colorCode = "\u001B[32m";
        } else {
            result = "Failed";
            colorCode = "\u001B[31m";
        }

        System.out.println(colorCode + testName + ": " + result + " (GCD: " + actual + ")");
        System.out.print("\u001B[0m");

        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            System.err.println("Thread sleep was interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
