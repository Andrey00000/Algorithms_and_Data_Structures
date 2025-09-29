package pr4.task2;

public class Phone {
    private String number;
    private String model;
    private double weight;

    public Phone(){
        this.model = "неизвестный";
        this.number = "неизвестный";
        this.weight = 0;
    }

    public Phone(String number, String model, double weight){
        this(number, model);
        this.weight = weight;

    }

    public Phone(String number, String model){
        this();
        this.number = number;
        this.model = model;
    }

    public void receiveCall(String name){
        System.out.println("Звонит " + name);
    }

    public void receiveCall(String callerName, String numberCaller){
        System.out.println("Звонит " + callerName + "с номера: " + numberCaller);
    }
    public void sendMessage(String... numbers){
           System.out.printf("Сообщение будет отправлено на %d номеров: ", numbers.length);
           for (String i : numbers){
               System.out.print(i + "; ");
           }
    }

    public String getNumber() {
        return number;
    }
}
