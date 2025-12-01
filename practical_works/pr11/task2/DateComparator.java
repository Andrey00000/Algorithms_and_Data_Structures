package pr11.task2;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class DateComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();

        System.out.println("=== СРАВНЕНИЕ ДАТ ===");
        System.out.println("Текущая дата: " + new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(currentDate));

        try {
            // Ввод даты от пользователя
            System.out.println("\n--- Ввод даты для сравнения ---");
            System.out.print("Введите день (1-31): ");
            int day = scanner.nextInt();
            System.out.print("Введите месяц (1-12): ");
            int month = scanner.nextInt();
            System.out.print("Введите год (например, 2024): ");
            int year = scanner.nextInt();
            System.out.print("Введите час (0-23): ");
            int hour = scanner.nextInt();
            System.out.print("Введите минуты (0-59): ");
            int minute = scanner.nextInt();

            // Устанавливаем дату в Calendar
            calendar.set(year, month - 1, day, hour, minute, 0);
            Date userDate = calendar.getTime();

            // Сравниваем
            compareDatesDetailed(currentDate, userDate);

        } catch (Exception e) {
            System.out.println("Ошибка ввода! Проверьте правильность введенных данных.");
        } finally {
            scanner.close();
        }
    }

    private static void compareDatesDetailed(Date currentDate, Date userDate) {
        SimpleDateFormat fullFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        System.out.println("\n" + "=".repeat(50));
        System.out.println("РЕЗУЛЬТАТ СРАВНЕНИЯ");
        System.out.println("=".repeat(50));

        System.out.println("Текущая системная дата: " + fullFormat.format(currentDate));
        System.out.println("Введенная пользователем дата: " + fullFormat.format(userDate));

        long diff = userDate.getTime() - currentDate.getTime();
        boolean isFuture = diff > 0;
        boolean isPresent = diff == 0;

        System.out.println("\nАНАЛИЗ ВРЕМЕННОГО ИНТЕРВАЛА:");

        if (isPresent) {
            System.out.println("Даты совпадают точно!");
        } else if (isFuture) {
            System.out.println("Введенная дата в БУДУЩЕМ");
        } else {
            System.out.println("Введенная дата в ПРОШЛОМ");
        }

    }
}