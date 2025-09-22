package pr2.task1;

public class TestAuthor {
    public static void main(String[] args){
        Author author1 = new Author("A. C. Пушкин", "pushkin@gmail.com", 'M');
        System.out.println("Имя автора: " + author1.getName());
        System.out.println("Почта автора: " + author1.getEmail());
        System.out.println("Пол автора: " + author1.getGender());
        System.out.println("Изменяем почту автору\nБыло:");
        System.out.println("" + author1);
        author1.setEmail("aspushkin@mirea.ru");
        System.out.println("Стало:\n"+author1);
    }
}
