package pr13.task5;

import java.util.Scanner;

public class StandartNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер: ");
        String str = sc.nextLine();
        int len = str.length();
        if (str.trim().length() >= 11 && str.trim().length() <= 15){

            String last_digits = str.substring(len-4);
            String medium_digits = str.substring(len-7, len-4);
            String start_digits = str.substring(len-10, len-7);

            if (str.startsWith("+")){
                String number_of_country = str.substring(1, len-10);
                System.out.printf("+%s %s-%s-%s%n", number_of_country, start_digits, medium_digits, last_digits);
            }
            else if (str.startsWith("8") && len == 11) {
                System.out.printf("+7 %s-%s-%s%n", start_digits, medium_digits, last_digits);
            }
            else{
                System.out.println("Это не номер телефона!");
            }
        }else {
            System.out.println("Это не номер телефона!");
        }
    }
}
