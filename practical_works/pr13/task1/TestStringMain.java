package pr13.task1;
import java.util.Scanner;

public class TestStringMain {
    public static void analyzeString(String str) {
        System.out.println("Исходная строка: \"" + str + "\"");
        System.out.println();

        // 2. Последний символ строки
        System.out.println("2. Последний символ: '" + str.charAt(str.length() - 1) + "'");

        // 3. Заканчивается ли на "!!!"
        System.out.println("3. Заканчивается на '!!!': " + str.endsWith("!!!"));

        // 4. Начинается ли на "I like"
        System.out.println("4. Начинается на 'I like': " + str.startsWith("I like"));

        // 5. Содержит ли "Java"
        System.out.println("5. Содержит 'Java': " + str.contains("Java"));

        // 6. Позиция подстроки "Java"
        int javaPosition = str.indexOf("Java");
        System.out.println("6. Позиция 'Java': " + (javaPosition != -1 ? javaPosition : "не найдено"));

        // 7. Замена всех 'a' на 'o'
        String replacedStr = str.replace('a', 'o');
        System.out.println("7. Замена 'a' на 'o': \"" + replacedStr + "\"");

        // 8. Верхний регистр
        System.out.println("8. В верхнем регистре: \"" + str.toUpperCase() + "\"");

        // 9. Нижний регистр
        System.out.println("9. В нижнем регистре: \"" + str.toLowerCase() + "\"");

        // 10. Вырезать "Java"
        if (javaPosition != -1) {
            String javaSubstring = str.substring(javaPosition, javaPosition + "Java".length());
            System.out.println("10. Вырезанная 'Java': \"" + javaSubstring + "\"");
        } else {
            System.out.println("10. Подстрока 'Java' не найдена");
        }
    }

    public static void main(String[] args) {
        String exampleString = "I like Java!!!";
        analyzeString(exampleString);
    }
}