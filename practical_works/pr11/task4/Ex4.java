package pr11.task4;

import java.util.*;
import java.text.SimpleDateFormat;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите дату и время:");
        System.out.print("Год Месяц Число: ");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();

        System.out.print("Часы Минуты: ");
        int hours = scanner.nextInt();
        int minutes = scanner.nextInt();

        // Создаем Date
        Date date = new Date(year - 1900, month - 1, day, hours, minutes);

        // Создаем Calendar
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day, hours, minutes);

        // Красивый вывод
        SimpleDateFormat sdf = new SimpleDateFormat("\n dd.MM.yyyy" + "\n    HH:mm");

        System.out.println("Calendar: " + sdf.format(cal.getTime()));

        scanner.close();
    }
}
