package pr14.task3;

import java.util.Scanner;
import java.util.regex.*;

public class FindCorrectPrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        // Простое регулярное выражение для поиска корректных цен
        String regex = "\\s\\d+(\\.\\d{2})?\\s*(USD|RUB|EUR)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Найдены корректные цены:");
        while (matcher.find()) {
            System.out.println("- " + matcher.group());
        }
    }
}