import java.util.Scanner;
public class Task_5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число, факториал которого нужен: ");
        try{
            int n = sc.nextInt();
            if (n >= 0){
                int fact = factorial(n);
                System.out.print("Ответ:"+fact);
            }
            else{
                System.out.print("Факториал отрицательного числа не существует");
            }
        }catch (Exception e){
            System.out.print("Введено не целое число!");
        }
    }

    public static int factorial(int n){
        int i = 1;
        int fact = 1;
        while (i <= n){
            fact *= i;
            i++;
        }
        return fact;
    }
}
