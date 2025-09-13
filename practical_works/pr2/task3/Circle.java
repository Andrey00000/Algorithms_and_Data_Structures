package pr2.task3;

public class Circle {
    private Point center;
    private double radius;
    private String color;

    public Circle(){
        this.center = new Point();
        this.radius = 1.0;
        this.color = "black";
    }

    public Circle(Point center, double radius, String color){
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPerimetr(){
        return 2 * Math.PI * this.getRadius();
    }

    public double getArea(){
        return Math.PI * this.getRadius() * this.getRadius();
    }

    @Override
    public String toString(){
        return "Circle{center=" + center + ", radius=" + radius + ", color=" + color + "}";
    }


}
