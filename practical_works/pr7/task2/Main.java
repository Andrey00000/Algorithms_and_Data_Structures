package pr7.task2;

public class Main {
    public static void main(String[] args){
        Movable rectangle = new MovableRectangle(0, 0, 5, 3, 2, 1);

        System.out.println("Initial state:");
        System.out.println(rectangle);

        System.out.println("\nAfter moving right:");
        rectangle.moveRight();
        System.out.println(rectangle);

        System.out.println("\nAfter moving down:");
        rectangle.moveDown();
        System.out.println(rectangle);
    }
}
