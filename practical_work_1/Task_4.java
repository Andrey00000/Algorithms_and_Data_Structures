public class Task_4 {
    public static void main(String[] args){
        System.out.println("Первые 10 чисел гармонического ряда:");

        double sum = 0.0;
        for (int i = 1; i <=10;i++){
            sum += 1.0 / i;
            System.out.printf("H(%2d) = %8.6f%n", i, sum);
        }
    }
}
