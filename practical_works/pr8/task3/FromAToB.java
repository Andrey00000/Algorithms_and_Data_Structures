package pr8.task3;

import java.util.Scanner;

public class FromAToB {
    public static void rec(int a, int b){
        if (a == b){
            System.out.print(a);
            return;
        }

        System.out.print(a + " ");

        int next = a < b ? a+1 : a-1;

        rec(next, b);

    }

    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    rec(a,b);
    }
}
