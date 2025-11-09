package pr11.task3;

import java.util.*;
import java.text.SimpleDateFormat;
public class Test {
    public static void main(String[] args){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        Student[] students = {
                new Student("Анна Иванова", 4.8, new Date(104, Calendar.MARCH, 15)),
                new Student("Петр Петров", 3.9, new Date(103, Calendar.JULY, 22)),
                new Student("Мария Сидорова", 4.5, new Date(102, Calendar.DECEMBER, 10))
        };

        for (Student student : students) {
            System.out.println("Короткий:  " + student.toString("short"));
            System.out.println("Средний:   " + student.toString("medium"));
            System.out.println("Длинный:   " + student.toString("long"));
            System.out.println("Полный:    " + student.toString("full"));
            System.out.println();
        }
    }
}
