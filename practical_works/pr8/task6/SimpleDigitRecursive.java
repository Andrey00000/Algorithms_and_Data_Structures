package pr8.task6;

import java.util.Scanner;

public class SimpleDigitRecursive {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите число для проверки: ");
        int n = sc.nextInt();

        if (isPrime(n)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        sc.close();
    }


    public static boolean isPrime(int n) {
        return isPrimeRecursive(n, 2);
    }


    private static boolean isPrimeRecursive(int n, int divisor) {

        if (divisor * divisor > n) {
            return true;
        }

        if (n % divisor == 0) {
            return false;
        }

        return isPrimeRecursive(n, divisor + 1);
    }
}
