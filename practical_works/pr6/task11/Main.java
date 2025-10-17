package pr6.task11;

public class Main {
    public static void main(String[] args) {

        Convertable[] converters = {
                new CelsiusToKelvin(25),
                new CelsiusToFahrenheit(25),
                new CelsiusToKelvin(300),
                new CelsiusToKelvin(77),
                new CelsiusToFahrenheit(300),
                new CelsiusToFahrenheit(77)
        };

        System.out.println("Конвертация температур:");

        for (Convertable converter : converters) {
            System.out.println(converter);
        }

        double temp = 100;

        Convertable toKelvin = new CelsiusToKelvin(temp);
        Convertable toFahrenheit = new CelsiusToFahrenheit(temp);

        System.out.println("Температура кипения воды:");
        System.out.println(toKelvin);
        System.out.println(toFahrenheit);
    }
}
