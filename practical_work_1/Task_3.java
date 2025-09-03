public class Task_3 {
    public static void main(String[] args){
        if (args.length ==0){
            System.out.print("Аргументов из командной строки не получено!");
        }
        else{
            for (String arg : args){
                System.out.print(arg + " ");
            }
        }
    }
}
