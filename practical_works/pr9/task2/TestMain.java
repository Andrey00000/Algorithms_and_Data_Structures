package pr9.task2;

public class TestMain {
    public static void main(String[] args) {
        // Используем МАССИВ вместо List
        Student[] students = {
                new Student("Иван", 4.5),
                new Student("Мария", 3.8),
                new Student("Петр", 4.9),
                new Student("Анна", 3.2),
                new Student("Сергей", 4.1)
        };

        System.out.println("До сортировки:");
        for (Student s : students) {
            System.out.println(s);
        }

        // Сортируем массив
        SortingStudentsByGPA sorter = new SortingStudentsByGPA();
        sorter.sort(students);

        System.out.println("\nПосле сортировки по убыванию GPA:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
