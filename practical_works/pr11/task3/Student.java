package pr11.task3;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Student {
    private String name;
    private double gpa;
    private Date birthDate; // дата рождения

    public Student(String name, double gpa, Date birthDate) {
        this.name = name;
        this.gpa = gpa;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return toString("short");
    }

    public String toString(String format1) {
        String birthDateFormatted = formatBirthDate(format1).format(birthDate);
        return name + " (GPA: " + gpa + ", Дата рождения: " + birthDateFormatted + ")";
    }


    public SimpleDateFormat formatBirthDate(String format) {
        switch (format.toLowerCase()) {
            case "short":
                return new SimpleDateFormat("dd.MM.yy");
            case "medium":
                return new SimpleDateFormat("dd.MM.yyyy");
            case "long":
                return new SimpleDateFormat("d MMMM yyyy");
            case "full":
                return new SimpleDateFormat("EEEE, d MMMM yyyy 'г.'");
            default:
                return new SimpleDateFormat("dd.MM.yyyy");
        }
    }
}