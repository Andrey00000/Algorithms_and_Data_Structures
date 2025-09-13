package pr2.task3;

public class Tester {
    private Circle[] circles;
    private int count;

    public Tester(int capacity){
        this.circles = new Circle[capacity];
        this.count = 0;
    }

    public void addCircle(Circle circle){
        if (count < circles.length){
            circles[count] = circle;
            count++;
        }
        else{
            System.out.println("Массив переполнен");
        }
    }

    public void printCircles(){
        System.out.println("Список всех окружностей:");
        for (int i = 0; i < count; i++){
            System.out.println((i+1) + ") " + circles[i]);
        }
    }

    public Circle[] getCircles() {
        return circles;
    }

    public int getCount() {
        return count;
    }


    public static void main(String[] args){
        Tester tester = new Tester(3);

        Point center1 = new Point();
        Circle circle1 = new Circle(center1, 5.0, "red");
        Circle circle2 = new Circle();
        Point center2 = new Point(4.5, 5.6);
        Circle circle3 = new Circle(center2, 5.6, "green");

        tester.addCircle(circle1);
        tester.addCircle(circle2);
        tester.addCircle(circle3);

        tester.printCircles();

        //работа методов
        for (int i = 0; i < tester.getCount(); i++){
            Circle c = tester.getCircles()[i];
            System.out.println("Окружность №" + (i+1) + ": площадь = " + String.format("%.2f", c.getArea()) + ", длина окружности = " + String.format("%.2f", c.getPerimetr()));
        }
    }
}
