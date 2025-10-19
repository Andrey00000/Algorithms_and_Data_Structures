package pr7.task4;

public class MathTest {
    public static void main(String[] args) {
        MathFunc math = new MathFunc();

        System.out.println("=== ТЕСТИРОВАНИЕ МАТЕМАТИЧЕСКИХ ФУНКЦИЙ ===");
        System.out.println("Число PI из интерфейса: " + MathCalculable.PI);
        System.out.println();

        // Тестирование работы с окружностями
        System.out.println("1. ВЫЧИСЛЕНИЕ ДЛИНЫ ОКРУЖНОСТИ:");
        double radius = 5.0;
        System.out.println("Радиус: " + radius);
        System.out.println("Длина окружности: " + math.circleLength(radius));
        System.out.println();

        // Тестирование комплексных чисел
        System.out.println("2. РАБОТА С КОМПЛЕКСНЫМИ ЧИСЛАМИ:");

        ComplexNumber num1 = new ComplexNumber(3, 4);    // 3 + 4i
        ComplexNumber num2 = new ComplexNumber(1, -2);   // 1 - 2i

        System.out.println("Комплексное число 1: " + num1);
        System.out.println("Комплексное число 2: " + num2);
        System.out.println();

        // Тестирование модуля комплексного числа
        System.out.println("3. МОДУЛИ КОМПЛЕКСНЫХ ЧИСЕЛ:");
        System.out.println("Модуль " + num1 + " = " + math.absComplex(num1));
        System.out.println("Модуль " + num2 + " = " + math.absComplex(num2));
        System.out.println();

        // Тестирование возведения в степень
        System.out.println("4. ВОЗВЕДЕНИЕ В СТЕПЕНЬ:");

        // Комплексные числа
        System.out.println("Комплексные числа:");
        for (int exp = 1; exp <= 3; exp++) {
            ComplexNumber result = math.pow(num1, exp);
            System.out.println("(" + num1 + ")^" + exp + " = " + result);
        }
        System.out.println();

        // Вещественные числа
        System.out.println("Вещественные числа:");
        double base = 2.5;
        for (int exp = 0; exp <= 3; exp++) {
            double result = math.pow(base, exp);
            System.out.println(base + "^" + exp + " = " + result);
        }
        System.out.println();

        // Дополнительные тесты
        System.out.println("6. ДОПОЛНИТЕЛЬНЫЕ ТЕСТЫ:");
        ComplexNumber num3 = new ComplexNumber(0, 1); // i
        System.out.println("Число i = " + num3);
        System.out.println("i^2 = " + math.pow(num3, 2)); // должно быть -1
        System.out.println("i^4 = " + math.pow(num3, 4)); // должно быть 1
    }
}
