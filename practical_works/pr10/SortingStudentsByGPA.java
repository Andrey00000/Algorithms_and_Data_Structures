package pr10;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class SortingStudentsByGPA implements Comparator<Student> {
    private Student[] iDNumber;

    public SortingStudentsByGPA() {
        iDNumber = new Student[0];
    }

    // 1) Метод заполнения массива случайными данными
    public void setArray(int size) {
        iDNumber = new Student[size];

        String[] firstNames = {"Иван", "Мария", "Петр", "Анна", "Сергей", "Ольга", "Алексей", "Елена", "Дмитрий", "Наталья"};
        String[] lastNames = {"Иванов(-a)", "Петров(-a)", "Сидоров(-a)", "Смирнов(-a)", "Кузнецов(-a)", "Попов(-a)", "Васильев(-a)", "Новиков(-a)", "Федоров(-a)", "Морозов(-a)"};
        String[] groups = {"ИТ-101", "ИТ-102", "ПМИ-201", "ПМИ-202", "ФИЗ-301", "ФИЗ-302"};
        String[] specialties = {"Информатика", "Математика", "Физика", "Программирование", "Анализ данных"};

        for (int i = 0; i < size; i++) {
            String firstName = firstNames[ThreadLocalRandom.current().nextInt(firstNames.length)];
            String lastName = lastNames[ThreadLocalRandom.current().nextInt(lastNames.length)];
            String group = groups[ThreadLocalRandom.current().nextInt(groups.length)];
            String specialty = specialties[ThreadLocalRandom.current().nextInt(specialties.length)];
            double gpa = ThreadLocalRandom.current().nextDouble(2.5, 5.0);
            int course = ThreadLocalRandom.current().nextInt(1, 5);

            iDNumber[i] = new Student(firstName, lastName, (double) Math.round(gpa * 100) / 100, specialty,course, group);
        }
    }

    // 2) РЕАЛИЗАЦИЯ РАЗЛИЧНЫХ КОМПАРАТОРОВ

    // Основной компаратор - по GPA по убыванию
    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.getGpa(), s1.getGpa());
    }

    // Компаратор для сортировки по имени (по возрастанию)
    public static class NameComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            int lastNameCompare = s1.getLastName().compareTo(s2.getLastName());
            if (lastNameCompare != 0) return lastNameCompare;
            return s1.getFirstName().compareTo(s2.getFirstName());
        }
    }

    // Компаратор для сортировки по курсу и группе
    public static class CourseGroupComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            int courseCompare = Integer.compare(s1.getCourse(), s2.getCourse());
            if (courseCompare != 0) return courseCompare;
            return s1.getGroup().compareTo(s2.getGroup());
        }
    }

    // Компаратор для сортировки по специальности и GPA
    public static class SpecialtyGPAComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            int specialtyCompare = s1.getSpecialty().compareTo(s2.getSpecialty());
            if (specialtyCompare != 0) return specialtyCompare;
            return Double.compare(s2.getGpa(), s1.getGpa()); // по убыванию внутри специальности
        }
    }

    public Comparator<Student> getComplexComparator1() {
        return Comparator
                .comparing(Student::getCourse)              // курс
                .thenComparing(Student::getSpecialty)       // специальность
                .thenComparing(Student::getGpa, Comparator.reverseOrder()) // GPA убывание
                .thenComparing(Student::getLastName)        // фамилия
                .thenComparing(Student::getFirstName);      // имя
    }

    // 3) МЕТОДЫ СОРТИРОВКИ

    // БЫСТРАЯ СОРТИРОВКА с возможностью выбора компаратора
    public void quicksort() {
        quicksort(this); // по умолчанию используем основной компаратор (по GPA)
    }

    public void quicksort(Comparator<Student> comparator) {
        if (iDNumber == null || iDNumber.length <= 1) return;
        quicksort(0, iDNumber.length - 1, comparator);
    }

    private void quicksort(int low, int high, Comparator<Student> comparator) {
        if (low < high) {
            int pi = partition(low, high, comparator);
            quicksort(low, pi - 1, comparator);
            quicksort(pi + 1, high, comparator);
        }
    }

    private int partition(int low, int high, Comparator<Student> comparator) {
        Student pivot = iDNumber[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(iDNumber[j], pivot) < 0) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, high);
        return i + 1;
    }
    public void mergeSort() {
        mergeSort(this); // по умолчанию используем основной компаратор
    }

    public void mergeSort(Comparator<Student> comparator) {
        if (iDNumber == null || iDNumber.length <= 1) return;
        Student[] temp = new Student[iDNumber.length];
        mergeSort(0, iDNumber.length - 1, temp, comparator);
    }

    private void mergeSort(int left, int right, Student[] temp, Comparator<Student> comparator) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(left, mid, temp, comparator);
            mergeSort(mid + 1, right, temp, comparator);

            merge(left, mid, right, temp, comparator);
        }
    }

    private void merge(int left, int mid, int right, Student[] temp, Comparator<Student> comparator) {
        for (int i = left; i <= right; i++) {
            temp[i] = iDNumber[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (comparator.compare(temp[i], temp[j]) <= 0) {
                iDNumber[k] = temp[i];
                i++;
            } else {
                iDNumber[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            iDNumber[k] = temp[i];
            k++;
            i++;
        }
    }


    // Вспомогательный метод для обмена
    private void swap(int i, int j) {
        Student temp = iDNumber[i];
        iDNumber[i] = iDNumber[j];
        iDNumber[j] = temp;
    }

    // 4) МЕТОД ДЛЯ ВЫВОДА МАССИВА
    public void outArray() {
        if (iDNumber == null || iDNumber.length == 0) {
            System.out.println("Массив пуст");
            return;
        }

        for (int i = 0; i < iDNumber.length; i++) {
            System.out.println((i + 1) + ". " + iDNumber[i]);
        }
    }

    public void outArray(String title) {
        System.out.println("\n" + "=".repeat(80));
        System.out.println(title);
        System.out.println("=".repeat(80));
        outArray();
    }

    // ГЛАВНЫЙ МЕТОД ДЛЯ ТЕСТИРОВАНИЯ
    public static void main(String[] args) {
        SortingStudentsByGPA sorter = new SortingStudentsByGPA();

        System.out.println("СОЗДАНИЕ И СОРТИРОВКА СПИСКА СТУДЕНТОВ");
        System.out.println("=".repeat(80));

        // Заполняем массив
        sorter.setArray(8);
        sorter.outArray("ИСХОДНЫЙ МАССИВ СТУДЕНТОВ");



        // 1. Сортировка по GPA (быстрая сортировка)
        sorter.quicksort();
        sorter.outArray("БЫСТРАЯ СОРТИРОВКА: по GPA (убывание)");

        // 2. Сортировка по имени (слиянием)
        sorter.mergeSort(new NameComparator());
        sorter.outArray("СОРТИРОВКА СЛИЯНИЕМ: по фамилии и имени (А-Я)");

        // 3. Сортировка по курсу и группе (быстрая)
        sorter.quicksort(new CourseGroupComparator());
        sorter.outArray("БЫСТРАЯ СОРТИРОВКА: по курсу и группе");

        // 4. Сортировка по специальности и GPA (слиянием)
        sorter.mergeSort(new SpecialtyGPAComparator());
        sorter.outArray("СОРТИРОВКА СЛИЯНИЕМ: по специальности и GPA (убывание)");

        // 5. Сложная сортировка (быстрая)
        sorter.quicksort(sorter.getComplexComparator1());
        sorter.outArray("БЫСТРАЯ СОРТИРОВКА: сложная сортировка: курс->специальность->GPA(убывание)->фамилия->имя ");
    }
}