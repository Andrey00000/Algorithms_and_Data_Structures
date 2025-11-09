package pr9.task2;

import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<Student>{

    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.getGpa(), s1.getGpa());
    }

    public void quickSort(Student[] students, int low, int high) {
        if (low < high) {
            // Находим индекс опорного элемента
            int pi = partition(students, low, high);

            // Рекурсивно сортируем левую и правую части
            quickSort(students, low, pi - 1);
            quickSort(students, pi + 1, high);
        }
    }

    private int partition(Student[] students, int low, int high) {
        // Опорный элемент - последний в текущем отрезке
        Student pivot = students[high];
        int i = low - 1;  // Индекс меньшего элемента

        for (int j = low; j < high; j++) {
            // Используем компаратор для сравнения!
            // Если students[j] должен идти ДО pivot (по нашим правилам)
            if (compare(students[j], pivot) < 0) {
                i++;
                swap(students, i, j);
            }
        }

        // Ставим pivot на правильную позицию
        swap(students, i + 1, high);
        return i + 1;
    }

    private void swap(Student[] students, int i, int j) {
        Student temp = students[i];
        students[i] = students[j];
        students[j] = temp;
    }

    // Удобный метод для сортировки всего массива
    public void sort(Student[] students) {
        if (students == null || students.length <= 1) return;
        quickSort(students, 0, students.length - 1);
    }
}
