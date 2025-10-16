package pr2.task7;

public class Book {
    private String author;
    private String name_book;
    private int realise_year;
    private String genre;

    public Book(String author, String name_book, int realise_year, String genre){
        this.author = author;
        this.name_book = name_book;
        this.realise_year = realise_year;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName_book() {
        return name_book;
    }

    public void setName_book(String name_book) {
        this.name_book = name_book;
    }

    public int getRealise_year() {
        return realise_year;
    }

    public void setRealise_year(int realise_year) {
        this.realise_year = realise_year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString(){
        return "Книга: " + name_book + ", автор: " + author + ", год выпуска: " + realise_year + ", жанр: " + genre;
    }
}
