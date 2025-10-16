package pr2.task7;

public class BookTest {
    public static void main(String[] args) {

        Shelf shelf = new Shelf(5);

        Book book1 = new Book("Лев Толстой", "Война и мир", 1867, "Роман");
        Book book2 = new Book("Фёдор Достоевский", "Преступление и наказание", 1866, "Роман");
        Book book3 = new Book("Антон Чехов", "Вишнёвый сад", 1904, "Пьеса");
        Book book4 = new Book("Иван Тургенев", "Отцы и дети", 1862, "Роман");
        Book book5 = new Book("Николай Гоголь", "Мёртвые души", 1842, "Поэма");

        shelf.addBook(book1);
        shelf.addBook(book2);
        shelf.addBook(book3);
        shelf.addBook(book4);
        shelf.addBook(book5);


        Book book6 = new Book("Александр Пушкин", "Евгений Онегин", 1833, "Роман в стихах");
        shelf.addBook(book6);

        System.out.println("=== ИСХОДНЫЙ СПИСОК КНИГ ===");
        printBooks(shelf.getBooks(), shelf.getCount());


        System.out.println("\n=== СОРТИРОВКА ПО ГОДУ ИЗДАНИЯ ===");
        shelf.sortYear(shelf.getBooks());
        printBooks(shelf.getBooks(), shelf.getCount());

        System.out.println("\n=== САМАЯ СТАРАЯ КНИГА ===");
        Book oldest = shelf.oldest_book();
        System.out.println(oldest);


        System.out.println("\n=== САМАЯ НОВАЯ КНИГА ===");
        Book youngest = shelf.yougest_book();
        System.out.println(youngest);
    }


    private static void printBooks(Book[] books, int count) {
        if (count == 0) {
            System.out.println("На полке нет книг");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + books[i]);
        }
    }
}