import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите целые числа через пробел: ");
        String input = sc.nextLine();
        String[] parts = input.split(" ");
        int[] temp = new int[parts.length];

        int count = 0;
        for(String part : parts){

            try {
                temp[count] = Integer.parseInt(part);
                count++;

            } catch (Exception e){
                System.out.println(part + " - не целое число, пропускаем");
            }
        }
        if (count == 0){
            System.out.println("Чисел не найдено");
            return;
        }

        int[] numbers = new int[count];
        System.out.print("Получившийся массив: ");
        for(int i = 0; i < count; i++){
            numbers[i] = temp[i];
            System.out.print(temp[i] + " ");
        }

        System.out.println();

        int sum = 0;
        int min = numbers[0];
        int max = numbers[0];
        int i = 0;

        while(i < numbers.length){
            sum += numbers[i];
            if (numbers[i] > max) max = numbers[i];
            if (numbers[i] < min) min = numbers[i];
            i++;
        }
        System.out.println("Сумма: " + sum);
        System.out.println("Максимальное число: " + max);
        System.out.print("Минимальное число: " + min);
    }
}
