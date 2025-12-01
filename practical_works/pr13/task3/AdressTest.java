package pr13.task3;

import java.util.StringTokenizer;

class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String building;
    private String apartment;

    // Конструктор
    public Address(String country, String region, String city, String street,
                   String house, String building, String apartment) {
        this.country = country.trim();
        this.region = region.trim();
        this.city = city.trim();
        this.street = street.trim();
        this.house = house.trim();
        this.building = building.trim();
        this.apartment = apartment.trim();
    }

    // Метод а) - используя split()
    public static Address parseWithSplit(String addressString) {
        String[] parts = addressString.split(",");

        // Проверяем, что у нас есть все 7 частей
        if (parts.length != 7) {
            throw new IllegalArgumentException("Адрес должен содержать 7 частей, разделенных запятыми");
        }

        // Убираем пробелы вокруг каждой части
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }

        return new Address(parts[0], parts[1], parts[2], parts[3],
                parts[4], parts[5], parts[6]);
    }

    // Метод б) - используя StringTokenizer
    public static Address parseWithTokenizer(String addressString) {
        // Используем несколько разделителей: запятая, точка, точка с запятой
        StringTokenizer tokenizer = new StringTokenizer(addressString, ",.;");

        // Собираем части адреса
        String[] parts = new String[7];
        int index = 0;

        while (tokenizer.hasMoreTokens() && index < 7) {
            parts[index] = tokenizer.nextToken().trim();
            index++;
        }

        // Проверяем, что собрали все 7 частей
        if (index != 7) {
            throw new IllegalArgumentException("Адрес должен содержать 7 частей");
        }

        return new Address(parts[0], parts[1], parts[2], parts[3],
                parts[4], parts[5], parts[6]);
    }

    // Геттеры
    public String getCountry() { return country; }
    public String getRegion() { return region; }
    public String getCity() { return city; }
    public String getStreet() { return street; }
    public String getHouse() { return house; }
    public String getBuilding() { return building; }
    public String getApartment() { return apartment; }

    @Override
    public String toString() {
        return String.format("Страна: %s, Регион: %s, Город: %s, Улица: %s, " +
                        "Дом: %s, Корпус: %s, Квартира: %s",
                country, region, city, street, house, building, apartment);
    }
}

// Проверочный класс
public class AdressTest {
    public static void main(String[] args) {
        System.out.println("=== Тестирование парсинга адресов ===\n");

        // Тестовые адресные строки
        String[] testAddresses = {
                // 1. Обычный адрес с запятыми
                "Россия, Московская область, Москва, Тверская улица, 10, 1, 25",

                // 2. Адрес с пробелами вокруг разделителей
                "Беларусь , Минская область , Минск , проспект Независимости , 15 , 2 , 100",

                // 3. Адрес с разными разделителями (для StringTokenizer)
                "Украина; Киевская область; Киев; Крещатик; 20; 3; 50",

                // 4. Адрес с точками в качестве разделителей
                "Казахстан. Алматинская область. Алматы. Абая. 30. 4. 75",

                // 5. Адрес со смешанными разделителями
                "США, Калифорния. Лос-Анджелес, Сансет-бульвар; 123, 5, 10"
        };

        // Тестируем метод split()
        System.out.println("--- Метод split() ---");
        for (int i = 0; i < Math.min(2, testAddresses.length); i++) {
            try {
                Address addr = Address.parseWithSplit(testAddresses[i]);
                System.out.println("Адрес " + (i+1) + ": " + addr);
            } catch (IllegalArgumentException e) {
                System.out.println("Адрес " + (i+1) + ": Ошибка - " + e.getMessage());
            }
        }

        System.out.println("\n--- Метод StringTokenizer ---");
        // Тестируем метод StringTokenizer на всех адресах
        for (int i = 0; i < testAddresses.length; i++) {
            try {
                Address addr = Address.parseWithTokenizer(testAddresses[i]);
                System.out.println("Адрес " + (i+1) + ": " + addr);
            } catch (IllegalArgumentException e) {
                System.out.println("Адрес " + (i+1) + ": Ошибка - " + e.getMessage());
            }
        }
    }
}
