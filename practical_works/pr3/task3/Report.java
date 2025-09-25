package pr3.task3;

public class Report {
    public static void generateReport(Employee[] employees){
        System.out.println("=== ОТЧЕТ О ЗАРПЛАТАХ СОТРУДНИКОВ ===");

        System.out.printf("%-25s %15s%n", "ФИО сотрудника", "Зарплата");

        for (Employee i : employees){
            System.out.printf("%-30s %15.2f руб.%n", i.getFullname(), i.getSalary());
        }
        printAnalysis(employees);
    }

    public static void printAnalysis(Employee[] employees){

        double totalSalary = 0;
        double maxSalary = -1;
        double minSalary = Double.MAX_VALUE;
        int count = 0;

        for (Employee employee : employees){
            double salary = employee.getSalary();
            totalSalary += salary;
            maxSalary = Math.max(maxSalary, salary);
            minSalary = Math.min(minSalary, salary);
            count++;
        }

        if (count > 0){
            double averageSalary = totalSalary/count;
            System.out.printf("Всего сотрудников: %d%n", count);
            System.out.printf("Общий бюджет: %,.2f руб.%n", totalSalary);
            System.out.printf("Средняя зарплата: %,.2f руб.%n", averageSalary);
            System.out.printf("Максимальная зарплата: %,.2f руб.%n", maxSalary);
            System.out.printf("Минимальная зарплата: %,.2f руб.%n", minSalary);
        }
    }
}
