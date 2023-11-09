import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Euclidean's Algorithm");

        System.out.print("Enter First Number: ");
        long num1 = sc.nextLong();

        System.out.print("Enter Second Number: ");
        long num2 = sc.nextLong();

        System.out.println("\nEuclidean Algorithm Table");
        System.out.println("-------------------------------------");
        System.out.println("|     M     |     N     |     R     |");
        System.out.println("-------------------------------------");

        long gcd = euclideanGCD(num1, num2);

        System.out.printf("\nThe GCD of %d and %d is : %d", num1, num2, gcd);

        sc.close();
    }

    public static long euclideanGCD(long m, long n) {
        if (n == 0) {
            System.out.println("-------------------------------------");
            return m;
        } else {
            long r = m % n;
            System.out.printf("|   %5d   |  %5d   |   %5d    |%n", m, n, r);
            return euclideanGCD(n, r);
        }
    }
}