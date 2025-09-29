package pr4.task8;

public class Square extends Rectangle{

    public Square(){
        super();
    }

    public Square(double side){
        super(side, side);
    }

    public Square(double side, String color, boolean filled){
        super(side, side, color, filled);
    }

    public double getSide(double side){
        return width;
    }

    public void setSide(double side){
        this.width = side;
        this.length = side;
    }

    @Override
    public void setWidth(double width){
        setSide(width);
    }

    @Override
    public void setLength(double length){
        setSide(length);
    }

    @Override
    public String toString(){
        return String.format("Квадрат: Площадь: %.2f, Периметер: %.2f, Цвет: %s, Заполненность: %s", getArea(), getPerimeter(), getColor(), isFilled());
    }
}
