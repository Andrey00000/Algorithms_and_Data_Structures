package pr7.task8;

interface Printable{
    void print();
}

class Book implements Printable{
    private String title;
    private String author;

    public Book(String title, String author) {
        this.author = author;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void print() {
        System.out.println(("Книга: '" + title  + "', автор: " + author));
    }

    public static void printBooks(Printable[] printables){
        System.out.println("Список книг:");

        for (Printable i : printables){
            if (i instanceof Book) {
                Book book = (Book) i;
                System.out.println("Книга: " + book.getTitle());
            }
        }
    }
}

class Shop implements Printable {
    private String name;
    private String address;

    public Shop(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public void print() {
        System.out.println("Магазин: '" + name + "', адрес: " + address);
    }
}

public class ISBook {
    public static void main(String[] args) {
        Printable[] printables = {
                new Book("Война и мир", "Лев Толстой"),
                new Shop("Книжный мир", "ул. Ленина, 15"),
                new Book("Преступление и наказание", "Федор Достоевский"),
                new Shop("Канцелярия", "пр. Победы, 32"),
                new Book("Мастер и Маргарита", "Михаил Булгаков")
        };

        System.out.println("Все объекты:");
        System.out.println("============");
        for (Printable item : printables) {
            item.print();
        }

        System.out.println();


        Book.printBooks(printables);
    }
}
