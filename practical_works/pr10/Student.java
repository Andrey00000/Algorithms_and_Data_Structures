package pr10;

public class Student {
    private String name, lastname, specialization, group;
    private int course;
    private double gpa;

    public Student(String name, String lastname, double gpa, String specialization, int course, String group) {
        this.name = name;
        this.lastname = lastname;
        this.gpa = gpa;
        this.specialization = specialization;
        this.course = course;
        this.group = group;
    }

    public String getFirstName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public String getLastName() {
        return lastname;
    }

    public String getSpecialty() {
        return specialization;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return name + " " + lastname +  " (" + gpa + "), Специальность: " + specialization + ", Курс обучения: " + course + ", Учебная группа: " + group;
    }
}
