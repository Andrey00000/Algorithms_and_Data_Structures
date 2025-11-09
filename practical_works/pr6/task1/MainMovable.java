package pr6.task1;


interface Movable{
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
}

class MovablePoint implements Movable{

    int x;
    int y;
    int xSpeed;
    int ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString(){
        return String.format("Координаты: (%d, %d), Cкорость по x: %d, Скорость по y: %d.", x, y, xSpeed, ySpeed);
    }

    @Override
    public void moveUp() {
        y -= ySpeed;
    }

    @Override
    public void moveDown() {
        y += ySpeed;
    }

    @Override
    public void moveLeft() {
        x -= xSpeed;
    }

    @Override
    public void moveRight() {
        x += xSpeed;
    }
}

class MovableCircle implements Movable{

    private int radius;
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed,int ySpeed, int radius) {
        this.radius = radius;
        this.center = new MovablePoint(x, y, xSpeed, ySpeed);
    }
    
    @Override
    public String toString(){
        return center + ", Радиус: " + radius;
    }

    @Override
    public void moveUp() {
        center.moveUp();
    }

    @Override
    public void moveDown() {
        center.moveDown();
    }

    @Override
    public void moveLeft() {
        center.moveLeft();
    }

    @Override
    public void moveRight() {
        center.moveRight();
    }
}
public class MainMovable {
    public static void main(String[] args){
        Movable circle = new MovableCircle(0, 0, 5, 3, 2);

        System.out.println("Initial state:");
        System.out.println(circle);

        System.out.println("\nAfter moving right:");
        circle.moveRight();
        System.out.println(circle);

        System.out.println("\nAfter moving down:");
        circle.moveDown();
        System.out.println(circle);
    }
}
