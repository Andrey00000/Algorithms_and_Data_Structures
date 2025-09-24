package pr2.task10;

public class HowMany {
    public static void main(String[] args){
        int count = 0;
        for (String i : args){
            if (!i.isEmpty()){
                count++;
            }
        }
        System.out.print("Количество слов: " + count);
    }
}
