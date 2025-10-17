package pr6.task11;

public class CelsiusToFahrenheit implements Convertable{
    private double celsius;

    public CelsiusToFahrenheit(double celsius) {
        this.celsius = celsius;
    }

    @Override
    public double convert() {
        return (celsius * 9/5) + 32;
    }

    @Override
    public String toString() {
        return celsius + " °C = " + convert() + " °F";
    }

}
