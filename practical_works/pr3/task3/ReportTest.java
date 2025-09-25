package pr3.task3;

public class ReportTest {
    public static void main(String[] args){
        Employee[] employees = {
                new Employee("Иванов Иван Иванович", 55000.50),
                new Employee("Петрова Анна Сергеевна", 72000.75),
                new Employee("Сидоров Алексей Петрович", 48000.25),
                new Employee("Кузнецова Мария Владимировна", 89000.00),
                new Employee("Смирнов Дмитрий Александрович", 61000.30),
                new Employee("Васильева Екатерина Игоревна", 95000.90)
        };

        Report.generateReport(employees);
    }
}
