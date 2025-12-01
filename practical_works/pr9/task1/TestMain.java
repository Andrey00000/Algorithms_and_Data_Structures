package pr9.task1;

// Класс, представляющий студента
class Student {
    private int id;        // ID студента
    private String name;   // Имя студента
    private double gpa;    // Средний балл

    // Конструктор класса - создает нового студента
    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', gpa=" + gpa + "}";
    }
}


public class TestMain{

    public static void insertionSort(Student[] students) {

        for (int i = 1; i < students.length; i++) {
            Student currentStudent = students[i];
            int previousIndex = i - 1;

            while (previousIndex >= 0 && students[previousIndex].getId() > currentStudent.getId()) {
                students[previousIndex + 1] = students[previousIndex];
                previousIndex--;
            }

            students[previousIndex + 1] = currentStudent;
        }
    }

    public static void printStudents(Student[] students, String message) {
        System.out.println("\n" + message);
        for (int i = 0; i < students.length; i++) {
            System.out.println((i + 1) + ". " + students[i]);
        }
    }

    public static void main(String[] args) {

        Student[] students = {
                new Student(5, "Анна", 4.5),
                new Student(2, "Иван", 4.2),
                new Student(8, "Мария", 4.8),
                new Student(1, "Петр", 3.9),
                new Student(4, "Ольга", 4.1),
                new Student(3, "Сергей", 4.3)
        };

        printStudents(students, "Исходный массив студентов:");

        insertionSort(students);

        printStudents(students, "Отсортированный массив студентов (по возрастанию ID):");
    }
}