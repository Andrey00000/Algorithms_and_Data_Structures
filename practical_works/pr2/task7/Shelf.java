package pr2.task7;

public class Shelf {
    private final Book[] books;
    private int count;

    public Shelf(int capacity){
        this.books = new Book[capacity];
        this.count = 0;
    }

    public void addBook(Book book){
        if (count < books.length){
            books[count] = book;
            count++;
        }
        else{
            System.out.println("Полка переполнена");
        }
    }

    public void sortYear(Book[] books) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (books[j].getRealise_year() > books[j + 1].getRealise_year()){
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }

    public Book oldest_book() {
        if (count == 0) return null;
        Book oldest = books[0];
        for (int i = 1; i < count; i++) {
            if (books[i].getRealise_year() > oldest.getRealise_year()) {
                oldest = books[i];
            }
        }
        return oldest;
    }

    public Book yougest_book(){
        if (count == 0) return null;
        Book youngest = books[0];
        for (int i = 1; i < count; i++) {
            if (books[i].getRealise_year() < youngest.getRealise_year()) {
                youngest = books[i];
            }
        }
        return books[0];
    }

    public Book[] getBooks() {
        return books;
    }

    public int getCount() {
        return count;
    }
}
