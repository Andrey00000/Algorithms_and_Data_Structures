package pr4.task2;

public class Tester {
    public static void main(String[] args) {
        Phone ph1 = new Phone("8(800)535-35-35", "IPhone", 200);
        Phone ph2 = new Phone("8(926)550-84-20", "Huawei", 300);
        Phone ph3 = new Phone("+1(818)795-4623", "Samsung", 250);

        ph1.receiveCall("Иван");
        ph2.receiveCall("Мама");
        ph3.receiveCall("Гор");

        System.out.println("Номер телефона №1: " + ph1.getNumber());
        System.out.println("Номер телефона №2: " + ph2.getNumber());
        System.out.println("Номер телефона №3: " + ph3.getNumber());

        ph1.sendMessage(ph2.getNumber(), ph3.getNumber());
    }
}
