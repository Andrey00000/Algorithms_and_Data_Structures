package pr13.task4;

import java.util.ArrayList;
import java.util.List;

public class Shirt {
    private final String id;
    private final String name;
    private final String color;
    private final String size;

    private Shirt(String id, String name, String color, String size) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.size = size;
    }
    public static List<Shirt> makeShirtArray(String[] list){
        String[] item;
        List<Shirt> shirts = new ArrayList<>();
        for (String i : list){
            item = i.split(",");
            shirts.add(new Shirt(item[0], item[1], item[2], item[3]));
        }
        return shirts;
    }

    public static void dispShirts(List<Shirt> shirts){
        for (int i = 0; i < shirts.size(); i++){
            System.out.println("Футболка №"+ (i+1)  + shirts.get(i).toString());
        }
    }

    @Override
    public String toString(){
        return String.format(":%nID: %s,%nНазвание: %s,%nЦвет: %s,%nРазмер: %s.%n", id, name, color, size);
    }
}
