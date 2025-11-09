package pr8.task4;
import java.util.Scanner;

public class SimpleDigitSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите k: ");
        int k = sc.nextInt();

        System.out.print("Введите s: ");
        int s = sc.nextInt();


        int result = find(k, s, true);
        System.out.println("Ответ: " + result);
    }

    public static int find(int digitsLeft, int sumLeft, boolean isFirst) {
        if (digitsLeft == 0) {
            return (sumLeft == 0) ? 1 : 0;
        }

        int total = 0;
        int start = isFirst ? 1 : 0;

        for (int d = start; d <= 9; d++) {
            if (d <= sumLeft) {
                total += find(digitsLeft - 1, sumLeft - d, false);
            }
        }

        return total;
    }
}

