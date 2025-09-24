package pr2.task8;
import java.util.Scanner;
public class Reverse {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку элементов массива(через пробел):");
        String input = sc.nextLine();
        String[] str = input.split(" ");
        System.out.println("Ваш массив со строками:");
        printArr(str);
        System.out.println("\nМассив в обратном порядке:");
        reverse(str);
        printArr(str);
    }

    public static void reverse(String[] str){
        int len = str.length/2;
        for (int i = 0; i <= len; i++){
            int j = str.length-1-i;
            String tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
        }
    }

    public static void printArr(String[] str){
         for (String i : str){
             if (!i.isEmpty()){
             System.out.print(i + " ");
            }
         }
    }
}
