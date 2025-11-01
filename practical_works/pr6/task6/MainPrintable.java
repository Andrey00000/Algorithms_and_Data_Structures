package pr6.task6;

public class MainPrintable {
    public static void main(String[] args) {

        Printable[] printables = {
                new Book("Война и мир", "Лев Толстой"),
                new Shop("Книжный мир", "ул. Ленина, 15"),
                new Book("Преступление и наказание", "Федор Достоевский"),
                new Shop("Канцелярия", "пр. Победы, 32"),
                new Book("Мастер и Маргарита", "Михаил Булгаков")
        };

        System.out.println("Список печатных объектов:");
        System.out.println("=========================");

        for (Printable item : printables) {
            item.print();
        }
    }
}
