package pr7.task5;

public class Main {
    public static void main(String[] args) {
        Str str = new StringOperations();

        System.out.println("Демонстрация работы со строками:");
        System.out.println("=================================");

        String[] testStrings = {
                "Hello",
                "Java",
                "Programming",
                "АБВГД",
                "12345",
                "A",
                ""
        };

        for (String testString : testStrings) {
            System.out.println("Строка на входе: " + testString);
            System.out.println("Длина строки: "+ str.len(testString));
            System.out.println("Нечётные элементы строки: " + str.nechetpos(testString));
            System.out.println("Реверсированная строка: "+ str.reverse(testString)+"\n");
        }
    }
}
