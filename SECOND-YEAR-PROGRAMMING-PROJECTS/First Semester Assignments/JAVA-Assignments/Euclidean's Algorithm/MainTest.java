import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    int testCaseNumber = 1;
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RESET = "\u001B[0m";

    @Test
    public void testEuclideanGCD1() {
        long result = Main.euclideanGCD(10, 5);
        assertEquals(5, result);
        System.out.println(ANSI_GREEN + "Test Case #" + testCaseNumber + ": Passed" + ANSI_RESET);
    }

    @Test
    public void testEuclideanGCD2() {
        long result = Main.euclideanGCD(608, 133);
        assertEquals(19, result);
        testCaseNumber++;
        System.out.println(ANSI_GREEN + "Test Case #" + testCaseNumber + ": Passed" + ANSI_RESET);
    }

    @Test
    public void testEuclideanGCD3() {
        long result = Main.euclideanGCD(9, 6);
        assertEquals(3, result);
        testCaseNumber++;
        System.out.println(ANSI_GREEN + "Test Case #" + testCaseNumber + ": Passed" + ANSI_RESET);
    }

    @Test
    public void testEuclideanGCD4() {
        long result = Main.euclideanGCD(17, 8);
        assertEquals(1, result);
        testCaseNumber++;
        System.out.println(ANSI_GREEN + "Test Case #" + testCaseNumber + ": Passed" + ANSI_RESET);
    }

    @Test
    public void testEuclideanGCD5() {
        long result = Main.euclideanGCD(14, 12);
        assertEquals(2, result);
        testCaseNumber++;
        System.out.println(ANSI_GREEN + "Test Case #" + testCaseNumber + ": Passed" + ANSI_RESET);
    }
}
