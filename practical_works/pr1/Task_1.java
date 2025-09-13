package pr1;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Task_1 {
    public static void main(String[] args) {
        int[] l = {2,4,5,6,23,56,45,678,56,289,456};
        int sum = 0;
        double average;

        for (int i=0; i < l.length; i++){
            sum += l[i];
        }
        average = (double) sum / l.length;

        System.out.printf("%d %.2f", sum, average);
    }
}