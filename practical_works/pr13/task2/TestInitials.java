package pr13.task2;

public class TestInitials {
    public static void main(String[] args) {
        Person person1 = new Person("Иванов", "Иван", "Иванович");
        Person person2 = new Person("Петров", "Петр", null);
        Person person3 = new Person("Сидоров", null, "Сидорович");
        Person person4 = new Person("Кузнецов", null, null);
        Person person5 = new Person(null, "Алексей", "Алексеевич");

        System.out.println(person1.getFullNameInitials());
        System.out.println(person2.getFullNameInitials());
        System.out.println(person3.getFullNameInitials());
        System.out.println(person4.getFullNameInitials());
        System.out.println(person5.getFullNameInitials());
    }
}
