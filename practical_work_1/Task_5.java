import java.util.Scanner;
public class Task_5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число, факториал которого нужен: ");
        try{
            int n = sc.nextInt();
            if (n >= 0){
                if (n > 20){
                    long fact = factorial(n);
                    System.out.print("Ответ:"+fact);
                }
                else{
                    System.out.print("Число слишком большое для типа long.");
                }
            }
            else{
                System.out.print("Факториал отрицательного числа не существует");
            }
        }catch (Exception e){
            System.out.print("Введено не целое число!");
        }
    }

    public static long factorial(int n){
        int i = 1;
        long fact = 1;
        while (i <= n){
            fact *= i;
            i++;
        }
        return fact;
    }
}
