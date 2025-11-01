package pr6.task3;


interface Nameable{
    String getName();
}

class Planet implements Nameable{
    private String name;
    private double radius;

    public Planet(String name, double radius){
        this.name = name;
        this.radius = radius;
    }
    @Override
    public String getName() {
        return this.name;
    }
}

class Car implements Nameable{
    private String brand;
    private String model;
    private int hp;

    public Car(String brand, String model, int hp) {
        this.brand = brand;
        this.model = model;
        this.hp = hp;
    }

    @Override
    public String getName() {
        return brand + " " + model;
    }
}

class Animal implements Nameable{
    private String type;
    private String name;

    public Animal(String type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.type + " " + this.name;
    }
}
public class NameableClass {
    public static void main(String[] args) {

        Nameable earth = new Planet("Земля", 6371.0);
        Nameable myCar = new Car("Toyota", "Camry", 203);
        Nameable cat = new Animal("Кот", "Барсик");

        System.out.println("Название планеты: " + earth.getName());
        System.out.println("Название машины: " + myCar.getName());
        System.out.println("Имя животного: " + cat.getName());

        System.out.println("\n--- Проверка через массив ---");
        Nameable[] nameables = {
                new Planet("Марс", 3389.5),
                new Car("BMW", "X5", 335),
                new Animal("Собака", "Шарик")
        };

        for (Nameable item : nameables) {
            System.out.println("Объект: " + item.getClass().getSimpleName() +
                    ", имя: " + item.getName());
        }
    }
}
