package pr3.exercise1;
import java.util.Random;

public class Main{
    public static void main(String[] args) {
        int[] array = new int[4];
        Random random = new Random();

        System.out.println("Массив:");

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(90) + 10;
            System.out.print(array[i] + " ");
        }

        //System.out.println();

        boolean isIncreasing = true;

        for (int i = 0; i < array.length - 1; i++) {

            if (array[i] >= array[i + 1]) {
                isIncreasing = false;
                break;
            }
        }

        if (isIncreasing) {
            System.out.println("Массив является строго возрастающей последовательностью");
        } else {
            System.out.println("Массив НЕ является строго возрастающей последовательностью");
        }
    }
}