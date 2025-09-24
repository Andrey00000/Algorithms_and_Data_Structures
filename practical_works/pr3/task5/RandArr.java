package pr3.task5;

import java.util.*;

public class RandArr {
    public static void main(String[] args){
        int n = validN();
        int[] arr = createArr(n);
        printArr(arr);
        List<Integer> list = chetArr(arr);
        printList(list);
    }

    private static int validN(){
        Scanner sc = new Scanner(System.in);
        int n = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Введите натуральное число(размер массива):");
            try {
                n = sc.nextInt();
                if (n > 0){
                    validInput = true;
                }
                else{
                    System.out.println("Число должно быть положительным. Повторите попытку!");
                }
            } catch (Exception e) {
                System.out.println("Введите натуральное число. Повторите попытку!");
                sc.nextLine();
            }
        }
        return n;
    }

    private static int[] createArr(int n){
        Random rand = new Random();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = rand.nextInt(n);
        }
        return arr;
    }

    private static void printArr(int[] arr){
        System.out.println("Полученный массив:");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    private static List<Integer> chetArr(int[] arr){
        List<Integer> list = new ArrayList<>();
        for(int i : arr){
            if ((i%2) == 0){
                list.add(i);
            }
        }
        return list;
    }

    private static void printList(List<Integer> list) {
        System.out.println("\nЧетные числа в массиве:");
        if (list.isEmpty()) {
            System.out.println("Четных чисел не найдено");
        } else {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
