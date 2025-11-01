package pr6.task6;

public class Book implements Printable{
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public void print() {
        System.out.println("Книга: '" + title + "', автор: " + author);
    }
}
