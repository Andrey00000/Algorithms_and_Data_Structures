package pr3.task3;

public class Employee {
    private String fullname;
    private double salary;

    public Employee(String fullname, double salary){
        this.fullname = fullname;
        this.salary = salary;
    }

    public String getFullname() {
        return fullname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String toString(){
        return String.format("Сотрудник: %s, Зарплата: %.2f", fullname, salary);
    }

}
