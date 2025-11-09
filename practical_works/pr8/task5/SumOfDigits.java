package pr8.task5;

import java.util.Scanner;

public class SumOfDigits {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите натуральное число N: ");
        int N = scanner.nextInt();

        int sum = sumDigits(N);
        System.out.println("Сумма цифр числа " + N + " = " + sum);

        scanner.close();
    }


    public static int sumDigits(int number) {
        if (number < 10) {
            return number;
        }

        return (number % 10) + sumDigits(number / 10);
    }
}