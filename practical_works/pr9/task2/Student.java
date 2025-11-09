package pr9.task2;

 public class Student {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public double getGpa() { return gpa; }

    @Override
    public String toString() {
        return name + " (" + gpa + ")";
    }
}