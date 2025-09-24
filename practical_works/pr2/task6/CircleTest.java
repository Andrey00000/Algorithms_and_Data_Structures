package pr2.task6;

public class CircleTest {
    public static void main(String[] args) {

        Circle circle1 = new Circle(0.0, 0.0, 5.0);
        Circle circle2 = new Circle(2.0, 3.0, 10.0);
        Circle circle3 = new Circle(1.0, 1.0, 3.0);


        System.out.println("Круг 1: центр(" + circle1.getX_center() + ", " +
                circle1.getY_center() + "), радиус=" + circle1.getRadius());
        System.out.println("Круг 2: центр(" + circle2.getX_center() + ", " +
                circle2.getY_center() + "), радиус=" + circle2.getRadius());


        circle1.setXY_center(5.5, 6.6);
        circle1.setRadius(7.5);
        System.out.println("\nПосле изменения:");
        System.out.println("Круг 1: центр(" + circle1.getX_center() + ", " +
                circle1.getY_center() + "), радиус=" + circle1.getRadius());


        System.out.println("\nСравнение кругов:");
        System.out.println("Круг1 < Круг2: " + circle1.less_than(circle2));
        System.out.println("Круг1 > Круг3: " + circle1.more_than(circle3));
        System.out.println("Круг2 > Круг3: " + circle2.more_than(circle3));

        System.out.println("Круг 1: периметр = " + circle1.getPerimetr() +
                ", площадь = " + circle1.getArea());
        System.out.println("Круг 2: периметр = " + circle2.getPerimetr() +
                ", площадь = " + circle2.getArea());
        System.out.println("Круг 3: периметр = " + circle3.getPerimetr() +
                ", площадь = " + circle3.getArea());
    }
}