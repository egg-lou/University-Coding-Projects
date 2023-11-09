import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Euclidean's Algorithm");

        System.out.print("Enter First Number: ");
        long num1 = sc.nextLong();

        System.out.print("Enter Second Number: ");
        long num2 = sc.nextLong();

        List<Long> gcdValues = new ArrayList<>();

        long gcd = euclideanGCD(num1, num2, gcdValues);

        System.out.println("\nEuclidean Algorithm Table");
        System.out.println("-------------------------------------");
        System.out.println("|     M     |     N     |     R     |");
        System.out.println("-------------------------------------");

        for (int i = 0; i < gcdValues.size() / 3; i++) {
            System.out.printf("|   %5d   |  %5d   |   %5d    |%n", gcdValues.get(i * 3), gcdValues.get(i * 3 + 1), gcdValues.get(i * 3 + 2));
        }

        System.out.println("-------------------------------------");
        System.out.printf("\nThe GCD of %d and %d is : %d", num1, num2, gcd);

        sc.close();
    }

    public static long euclideanGCD(long m, long n, List<Long> gcdValues) {
        while (n != 0) {
            long r = m % n;
            gcdValues.add(m);
            gcdValues.add(n);
            gcdValues.add(r);
            m = n;
            n = r;
        }
        return m;
    }
}
