package pr2.task6;

public class Circle {
    private double x_center;
    private double y_center;
    private double radius;

    public Circle(double x_center, double y_center, double radius){
        this.x_center = x_center;
        this.y_center = y_center;
        this.radius = radius;
    }

    public double getX_center() {
        return x_center;
    }

    public void setX_center(double x_center) {
        this.x_center = x_center;
    }

    public double getY_center() {
        return y_center;
    }

    public void setY_center(double y_center) {
        this.y_center = y_center;
    }

    public void setXY_center(double x_center, double y_center){
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getPerimetr(){
        return 2 * Math.PI * getRadius();
    }

    public double getArea(){
        return Math.PI * getRadius() * getRadius();
    }

    public boolean less_than(Circle obj) {
        return obj != null && this.getRadius() < obj.getRadius();
    }

    public boolean more_than(Circle obj){
        return obj != null && this.getRadius() > obj.getRadius();
    }
}
