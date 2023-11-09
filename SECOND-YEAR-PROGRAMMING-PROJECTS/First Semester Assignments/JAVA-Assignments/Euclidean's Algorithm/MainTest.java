import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MainTest {
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RESET = "\u001B[0m";

    @Test
    public void testEuclideanGCD1() {
        long result = Main.euclideanGCD(10, 5);
        assertEquals(5, result);
        System.out.println(ANSI_GREEN + "Test Case #" + 1 + ": Passed" + ANSI_RESET);
    }

    @Test
    public void testEuclideanGCD2() {
        long result = Main.euclideanGCD(608, 133);
        assertEquals(19, result);
        System.out.println(ANSI_GREEN + "Test Case #" + 2+ ": Passed" + ANSI_RESET);
    }

    @Test
    public void testEuclideanGCD3() {
        long result = Main.euclideanGCD(9, 6);
        assertEquals(3, result);
        System.out.println(ANSI_GREEN + "Test Case #" + 3 + ": Passed" + ANSI_RESET);
    }

    @Test
    public void testEuclideanGCD4() {
        long result = Main.euclideanGCD(17, 8);
        assertEquals(1, result);
        System.out.println(ANSI_GREEN + "Test Case #" + 4  + ": Passed" + ANSI_RESET);
    }

    @Test
    public void testEuclideanGCD5() {
        long result = Main.euclideanGCD(14, 12);
        assertEquals(2, result);
        System.out.println(ANSI_GREEN + "Test Case #" + 5 + ": Passed" + ANSI_RESET);
    }
}
