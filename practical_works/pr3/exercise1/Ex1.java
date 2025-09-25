package pr3.exercise1;

public class Ex1 {
    public static void  main(String[] args){
        System.out.println("1. Создание объектов Double using valueOf():");

        Double doubleObj1 = Double.valueOf(3.14);
        System.out.println("Double из double: " + doubleObj1);

        Double doubleObj2 = Double.valueOf("2.718");
        System.out.println("Double из строки: " + doubleObj2);

        Double doubleObj3 = Double.valueOf(100);
        System.out.println("Double из int: " + doubleObj3);

        System.out.println("2. Преобразование String к double, используя parseDouble():");

        double primitiveDouble = Double.parseDouble("123.45");
        System.out.println("double из String: " + primitiveDouble);

        System.out.println("3. Преобразование Double ко всем примитивным типам:");

        Double doubleValue = Double.valueOf(123.456);
        System.out.println("Исходный Double: " + doubleValue);


        double toDouble = doubleValue.doubleValue();
        System.out.println("double: " + toDouble);

        float toFloat = doubleValue.floatValue();
        System.out.println("float: " + toFloat);

        long toLong = doubleValue.longValue();
        System.out.println("long: " + toLong);

        int toInt = doubleValue.intValue();
        System.out.println("int: " + toInt);

        short toShort = doubleValue.shortValue();
        System.out.println("short: " + toShort);

        byte toByte = doubleValue.byteValue();
        System.out.println("byte: " + toByte);

        System.out.println("5. Преобразование double к строке:");

        String d1 = Double.toString(3.14);
        System.out.println("Double.toString(3.14) = \"" + d1 + "\"");

    }
}
