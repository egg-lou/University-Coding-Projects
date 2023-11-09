public class Test {

    public static void main(String[] args) {
        System.out.println("Testing the Euclidean GCD function with different inputs:");

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

        for (int i = 0; i < testCases.length; i++) {
            long[] testCase = testCases[i];
            long input1 = testCase[0];
            long input2 = testCase[1];
            long expected = testCase[2];
            long actual = Main.euclideanGCD(input1, input2);
            printTestResult("Test #" + (i + 1), actual, expected);
        }
    }

    public static void printTestResult(String testName, long actual, long expected) {
        String result;
        String colorCode;

        if (actual == expected) {
            result = "Passed";
            colorCode = "\u001B[32m"; 
        } else {
            result = "Failed";
            colorCode = "\u001B[31m";
        }

        System.out.println(colorCode + testName + ": " + result + " (" + actual + ")");
        System.out.print("\u001B[0m");
    }
}

